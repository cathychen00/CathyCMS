package com.cathy.cms.controller;

import cms.cathy.common.utils.ConstantHelper;
import cms.cathy.common.utils.DateUtils;
import cms.cathy.common.utils.ExcelUtils;
import com.cathy.cms.service.RoleService;
import com.cathy.cms.service.UserService;
import com.cathy.common.models.PageModel;
import com.data.model.UserQueryDTO;
import com.data.pojo.CmsRole;
import com.data.pojo.CmsUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 陈敬 on 17/9/12.
 * 用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final Integer PAGE_SIZE = 10;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/list")
    public String list(UserQueryDTO queryDTO, Model model) {
        if (queryDTO == null) {
            queryDTO = new UserQueryDTO();
        }
        queryDTO.setPageSize(PAGE_SIZE);

        int totalCount = userService.count(queryDTO);
        //todo：补全用户角色
        PageModel<CmsUser> pageModel = userService.findUsersPaging(queryDTO);
        pageModel.setTotalCount(totalCount);

        model.addAttribute("query", queryDTO);
        model.addAttribute("pageModel", pageModel);
        return "/user/list";
    }

    @RequestMapping("/edit")
    public String edit(Integer userId, Model model) {
        CmsUser user;
        String pageTitle = "";
        if (userId == null || userId == 0) {
            user = new CmsUser();
            pageTitle = "新增用户";
        } else {
            user = userService.findByUserId(userId);
            pageTitle = "编辑用户";
        }
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", pageTitle);

        //全部资源
        List<CmsRole> roles = roleService.listAllRoles(ConstantHelper.DELETE_FLAG_NORMAL);
        model.addAttribute("roles", roles);

        //角色拥有的资源
        Set<CmsRole> userRoles = roleService.findByUserId(userId);
        List<String> userRoleIds = new ArrayList<>();
        for (CmsRole r : userRoles) {
            userRoleIds.add(r.getRoleId().toString());
        }
        model.addAttribute("roleIds", String.join(",", userRoleIds));

        return "/user/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    public int save(CmsUser user, Integer[] roleIds) {
        int result;
        if (user.getUserId() == null || user.getUserId() == 0) {
            result = userService.insert(user);
        } else {
            result = userService.update(user);
        }

        //保存用户关联的角色
        userService.saveUserRoleRelation(user.getUserId(), roleIds);

        return result;
    }

    @RequestMapping("/validateUsername")
    @ResponseBody
    public boolean validateUsername(String username) {
        CmsUser user = userService.findUserByName(username);
        if (user != null && user.getUserId() > 0) {
            return false;
        }
        return true;
    }

    @RequestMapping("/export")
    public String export(String username, HttpServletRequest request, HttpServletResponse repsonse) {
        //查询用户数据
        UserQueryDTO queryDTO = new UserQueryDTO() {{
            setUsername(username);
        }};
        List<CmsUser> userList = userService.findUser(queryDTO);

        //表头
        Map<String, String> headNameMap = new LinkedHashMap<String, String>();
        headNameMap.put("userId", "ID");
        headNameMap.put("roleName", "角色");
        headNameMap.put("userName", "账号");
        headNameMap.put("realName", "姓名");
        headNameMap.put("mobile", "电话号码");
        headNameMap.put("createDate", "创建时间");
        headNameMap.put("status", "状态");

        //表格数据
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (userList != null && userList.size() > 0) {
            for (CmsUser user : userList) {
                String statusName = "正常";
                if (StringUtils.isNotBlank(user.getDeleteFlag()) && user.getDeleteFlag().equals(ConstantHelper.DELETE_FLAG_DELETED)) {
                    statusName = "删除";
                }

                String createDate = "";
                if (user.getCreateDate() != null) {
                    createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getCreateDate());
                }

                String roleName = "";
                Set<CmsRole> roleSet = roleService.findByUserId(user.getUserId());
                if (roleSet != null && roleSet.size() > 0) {
                    for (CmsRole r : roleSet) {
                        roleName += r.getName() + " ";
                    }
                }

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userId", user.getUserId());
                map.put("roleName", roleName);
                map.put("userName", user.getUsername());
                map.put("realName", user.getRealName());
                map.put("mobile", user.getMobile());
                map.put("createDate", createDate);
                map.put("status", statusName);
                list.add(map);
            }
        }

        ExcelUtils.exportXlsx(repsonse, "用户", headNameMap, list);
        return null;
    }


    @RequestMapping("/update_pwd")
    public String updatePassword(Model model, HttpSession session) {
        session.setAttribute("test1", "test1");
        return "/user/updatePwd";
    }
}
