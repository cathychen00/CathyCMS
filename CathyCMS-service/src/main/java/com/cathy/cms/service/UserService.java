package com.cathy.cms.service;

import com.cathy.common.models.PageModel;
import com.data.model.UserQueryDTO;
import com.data.pojo.CmsUser;

import java.util.List;

/**
 * Created by 陈敬 on 17/9/8.
 */
public interface UserService {
    CmsUser findUserByName(String username);

    List<CmsUser> findUser(UserQueryDTO queryDTO);

    PageModel<CmsUser> findUsersPaging(UserQueryDTO queryDTO);

    int count(UserQueryDTO queryDTO);

    CmsUser findByUserId(Integer userId);

    int insert(CmsUser user);

    int update(CmsUser user);

    void saveUserRoleRelation(Integer userId, Integer[] roleIds);
}
