package com.cathy.cms.service.impl;

import com.cathy.cms.service.UserService;
import com.data.pojo.CmsUser;
import org.springframework.stereotype.Service;

/**
 * Created by 陈敬 on 17/9/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public CmsUser findUserByName(final String username) {
        return new CmsUser(){{
            setUsername(username);
            setUserId(1);
        }};
    }
}
