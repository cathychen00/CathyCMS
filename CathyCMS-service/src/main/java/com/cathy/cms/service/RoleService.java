package com.cathy.cms.service;

import com.data.pojo.CmsRole;

import java.util.List;
import java.util.Set;

/**
 * Created by 陈敬 on 17/9/8.
 */
public interface RoleService {
    Set<CmsRole> findByUserId(Integer userId);

    List<CmsRole> listAllRoles();

    CmsRole findByRoleId(Integer roleId);

    int deleteByRoleId(int roleId);

    int resetByRoleId(int roleId);

    int insert(CmsRole role);

    int update(CmsRole role);
}
