package com.cathy.cms.service;

import com.data.pojo.CmsResource;

import java.util.Set;

/**
 * Created by 陈敬 on 17/9/8.
 */
public interface ResourceService {
    Set<CmsResource> findByRoleId(Integer roleId);
}
