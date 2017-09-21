package com.cathy.cms.service;

import com.cathy.common.models.PageModel;
import com.data.model.UserQueryDTO;
import com.data.pojo.CmsUser;

/**
 * Created by 陈敬 on 17/9/8.
 */
public interface UserService {
    CmsUser findUserByName(String username);

    PageModel<CmsUser> findUsersPaging(UserQueryDTO queryDTO);

    int count(UserQueryDTO queryDTO);
}
