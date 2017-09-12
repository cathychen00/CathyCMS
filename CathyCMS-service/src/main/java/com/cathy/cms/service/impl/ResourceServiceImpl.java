package com.cathy.cms.service.impl;

import com.cathy.cms.service.ResourceService;
import com.data.mapper.CmsResourceMapper;
import com.data.pojo.CmsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by 陈敬 on 17/9/8.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    CmsResourceMapper resourceMapper;

    @Override
    public Set<CmsResource> findByRoleId(Integer roleId) {
        return resourceMapper.findByRoleId(roleId);
    }
}
