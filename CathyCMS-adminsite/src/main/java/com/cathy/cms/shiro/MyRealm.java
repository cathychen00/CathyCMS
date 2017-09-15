package com.cathy.cms.shiro;

import com.cathy.cms.service.ResourceService;
import com.cathy.cms.service.RoleService;
import com.cathy.cms.service.UserService;
import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.utils.WebHelper;
import com.data.model.ResourceItem;
import com.data.pojo.CmsResource;
import com.data.pojo.CmsRole;
import com.data.pojo.CmsUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by 陈敬 on 17/9/12.
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    ResourceService resourceService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        CmsUser user = userService.findUserByName(userName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<CmsRole> roleSet = roleService.findByUserId(user.getUserId());

        Set<String> permissionSet = new HashSet<String>();
        for (CmsRole role : roleSet) {
            if (StringUtils.isNotBlank(role.getRoleName())) {
                info.addRole(role.getRoleName());

                Set<CmsResource> resources = resourceService.findByRoleId(role.getRoleId());
                if (resources != null && !resources.isEmpty()) {
                    for (CmsResource r : resources) {
                        if (StringUtils.isNotBlank(r.getUrl())) {
                            permissionSet.add(r.getUrl());
                        }
                    }
                }
            }
        }

        info.addStringPermissions(permissionSet);
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if (StringUtils.isEmpty(token.getUsername())) {
            return null;
        }

        CmsUser user = userService.findUserByName(token.getUsername());
        if (user != null) {

            if (user.getStatus() == ConstantHelper.STATUS_NO) {
                throw new LockedAccountException();
            }

            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());

            setSession(WebHelper.SESSION_LOGIN_USER, user);

            initMenu(user.getUserId());

            return authcInfo;
        }

        return null;
    }

    private void initMenu(int userId) {
        List<ResourceItem> result = new ArrayList<ResourceItem>();
        List<ResourceItem> allMenu = resourceService.findAllMenu();
        Set<Integer> userResourceIds = resourceService.findResourceIdsByUserId(userId);

        if (allMenu != null && !allMenu.isEmpty() && userResourceIds != null && !userResourceIds.isEmpty()) {
            for (ResourceItem menu : allMenu) {
                ResourceItem item = allowResource(menu, userResourceIds);
                if (item != null) {
                    result.add(item);
                }
            }
        }

        setSession(WebHelper.SESSION_MENU_RESOURCE, result);
    }

    private ResourceItem allowResource(ResourceItem menu, Set<Integer> userResourceIds) {
        if (!userResourceIds.contains(menu.getCurrentResource().getResourceId())) {
            return null;
        }

        List<ResourceItem> children = menu.getChildren();
        List<ResourceItem> allowResources = new ArrayList<ResourceItem>();
        if (children != null && !children.isEmpty()) {
            for (ResourceItem child : children) {
                ResourceItem allowChildResource = allowResource(child, userResourceIds);
                if (allowChildResource != null) {
                    allowResources.add(allowChildResource);
                }
            }
            menu.setChildren(allowResources);
        }

        return menu;
    }

    private void setSession(Object key, Object value) {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            Session session = subject.getSession();
            if (session != null) {
                session.setAttribute(key, value);
            }
        }
    }

}
