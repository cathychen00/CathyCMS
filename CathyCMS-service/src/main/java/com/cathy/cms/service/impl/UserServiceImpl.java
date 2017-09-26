package com.cathy.cms.service.impl;

import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.service.UserService;
import com.cathy.common.models.PageModel;
import com.data.mapper.CmsUserMapper;
import com.data.mapper.CmsUserRoleRelMapper;
import com.data.model.UserQueryDTO;
import com.data.pojo.CmsUser;
import com.data.pojo.CmsUserCriteria;
import com.data.pojo.CmsUserRoleRelKey;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 陈敬 on 17/9/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    CmsUserMapper userMapper;

    @Autowired
    CmsUserRoleRelMapper userRoleRelMapper;

    public CmsUser findUserByName(final String username) {
        CmsUserCriteria criteria=new CmsUserCriteria();
        criteria.createCriteria().andUsernameEqualTo(username);

        List<CmsUser> users=userMapper.selectByExample(criteria);

        if(users==null||users.size()==0){
            return null;
        }

        return users.get(0);
    }


    @Override
    public List<CmsUser> findUser(UserQueryDTO queryDTO) {
        CmsUserCriteria criteria=new CmsUserCriteria();
        if(queryDTO!=null){
            if(StringUtils.isNotBlank(queryDTO.getUsername())){
                criteria.createCriteria().andUsernameLike("%"+queryDTO.getUsername()+"%");
            }
        }

        return userMapper.selectByExample(criteria);
    }

    @Override
    public PageModel<CmsUser> findUsersPaging(UserQueryDTO queryDTO) {
        PageModel<CmsUser> pageModel=new PageModel<CmsUser>();
        pageModel.setPageIndex(queryDTO.getPageIndex());
        pageModel.setPageSize(queryDTO.getPageSize());

        CmsUserCriteria criteria=new CmsUserCriteria();
        if(queryDTO!=null){
            if(StringUtils.isNotBlank(queryDTO.getUsername())){
                criteria.createCriteria().andUsernameLike("%"+queryDTO.getUsername()+"%");
            }
        }
        RowBounds rowBounds=new RowBounds((queryDTO.getPageIndex()-1)*queryDTO.getPageSize(),queryDTO.getPageSize());
        List<CmsUser> users=userMapper.selectByExampleWithRowbounds(criteria,rowBounds);
        pageModel.setItems(users);

        return pageModel;
    }

    @Override
    public int count(UserQueryDTO queryDTO) {
        CmsUserCriteria criteria=new CmsUserCriteria();

        if(queryDTO!=null){
            if(StringUtils.isNotBlank(queryDTO.getUsername())){
                criteria.createCriteria().andUsernameEqualTo(queryDTO.getUsername());
            }
        }

        return userMapper.count(criteria);
    }

    @Override
    public CmsUser findByUserId(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int insert(CmsUser user) {
        Date now=new Date();
        user.setUpdateDate(now);
        user.setCreateDate(now);
        user.setDeleteFlag(ConstantHelper.DELETE_FLAG_NORMAL);
        user.setPassword(ConstantHelper.PASSWORD);

        return userMapper.insert(user);
    }

    @Override
    public int update(CmsUser user) {
        CmsUser updateUser=userMapper.selectByPrimaryKey(user.getUserId());
        if(updateUser==null){
            return 0;
        }
        updateUser.setUpdateDate(new Date());
        updateUser.setEmail(user.getEmail());
        updateUser.setRealName(user.getRealName());

        return userMapper.updateByPrimaryKey(updateUser);
    }

    @Override
    public void saveUserRoleRelation(final Integer userId, Integer[] roleIds) {
        if(userId==null||userId<=0){
            return ;
        }
        userRoleRelMapper.deleteByUserId(userId);

        if(roleIds==null||roleIds.length==0){
            return ;
        }

        for(final Integer roleId:roleIds){
            CmsUserRoleRelKey relation=new CmsUserRoleRelKey(){{
                setUserId(userId);
                setRoleId(roleId);
            }};

            userRoleRelMapper.insert(relation);
        }
    }
}
