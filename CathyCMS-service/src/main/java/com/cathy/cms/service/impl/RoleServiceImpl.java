package com.cathy.cms.service.impl;

import com.cathy.cms.service.RoleService;
import com.data.mapper.CmsRoleMapper;
import com.data.pojo.CmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by 陈敬 on 17/9/8.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    CmsRoleMapper roleMapper;

    @Override
    public Set<CmsRole> findByUserId(Integer userId) {
        return roleMapper.findByUserId(userId);
    }
}
