package com.cathy.cms.service;

import com.data.model.ResourceItem;
import com.data.pojo.CmsResource;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 陈敬 on 17/9/8.
 */
public interface ResourceService {
    Set<CmsResource> findByRoleId(Integer roleId);

    List<CmsResource> listAllResources();

    List<CmsResource> listResourcesByType(String type);

    List<ResourceItem> findAllMenu();

    List<CmsResource> findByUserId(int userId);

    Set<Integer> findResourceIdsByUserId(int userId);

    CmsResource findByResourceId(Integer resourceId);

    void insertResource(CmsResource resource);

    void updateResource(CmsResource resource);

    void deleteResource(int id);

    void resetResource(int id);

    List<Map<String, Object>> getTreeMap();
}
