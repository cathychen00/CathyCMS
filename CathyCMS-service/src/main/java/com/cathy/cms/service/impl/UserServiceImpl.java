package com.cathy.cms.service.impl;

import com.cathy.cms.service.UserService;
import com.data.mapper.CmsUserMapper;
import com.data.pojo.CmsUser;
import com.data.pojo.CmsUserCriteria;
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
}
