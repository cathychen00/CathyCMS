package com.cathy.cms.service.impl;

import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.service.RoleService;
import com.data.mapper.CmsRoleMapper;
import com.data.pojo.CmsRole;
import com.data.pojo.CmsRoleCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

    @Override
    public List<CmsRole> listAllRoles() {
        CmsRoleCriteria criteria=new CmsRoleCriteria();
        return roleMapper.selectByExample(criteria);
    }

    @Override
    public CmsRole findByRoleId(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int deleteByRoleId(int roleId) {
        CmsRole role=roleMapper.selectByPrimaryKey(roleId);
        if(role==null){
            return 0;
        }

        role.setDeleteFlag(ConstantHelper.DELETE_FLAG_DELETED);
        role.setUpdateDate(new Date());
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int resetByRoleId(int roleId) {
        CmsRole role=roleMapper.selectByPrimaryKey(roleId);
        if(role==null){
            return 0;
        }

        role.setDeleteFlag(ConstantHelper.DELETE_FLAG_NORMAL);
        role.setUpdateDate(new Date());
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int insert(CmsRole role) {
        role.setCreateDate(new Date());
        role.setUpdateDate(new Date());
        role.setDeleteFlag(ConstantHelper.DELETE_FLAG_NORMAL);
        return roleMapper.insert(role);
    }

    @Override
    public int update(CmsRole roleUpdate) {
        CmsRole role=roleMapper.selectByPrimaryKey(roleUpdate.getRoleId());
        role.setUpdateDate(new Date());
        role.setName(roleUpdate.getName());
        role.setDescription(roleUpdate.getDescription());
        //todo:更新角色关联的资源

        return roleMapper.updateByPrimaryKey(role);
    }
}
