package com.cathy.cms.service.impl;

import com.cathy.cms.service.UserService;
import com.cathy.common.models.PageModel;
import com.data.mapper.CmsUserMapper;
import com.data.model.UserQueryDTO;
import com.data.pojo.CmsUser;
import com.data.pojo.CmsUserCriteria;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 陈敬 on 17/9/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    CmsUserMapper userMapper;

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
    public PageModel<CmsUser> findUsersPaging(UserQueryDTO queryDTO) {
        PageModel<CmsUser> pageModel=new PageModel<CmsUser>();
        pageModel.setPageIndex(queryDTO.getPageIndex());
        pageModel.setPageSize(queryDTO.getPageSize());

        CmsUserCriteria criteria=new CmsUserCriteria();
        if(queryDTO!=null){
            if(StringUtils.isNotBlank(queryDTO.getUsername())){
                criteria.createCriteria().andUsernameEqualTo(queryDTO.getUsername());
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
}
