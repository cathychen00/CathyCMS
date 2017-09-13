package com.cathy.cms.service.impl;

import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.service.ResourceService;
import com.data.mapper.CmsResourceMapper;
import com.data.model.ResourceItem;
import com.data.pojo.CmsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<ResourceItem> findAllMenu() {
        List<CmsResource> allResources = resourceMapper.findAllResources(ConstantHelper.DELETE_FLAG_NORMAL);

        List<ResourceItem> menus = new ArrayList<ResourceItem>();

        if (allResources != null && !allResources.isEmpty()) {
            Map<Integer, ResourceItem> map = new HashMap<Integer, ResourceItem>();
            for (final CmsResource resource : allResources) {
                map.put(resource.getResourceId(), new ResourceItem() {{
                    setResource(resource);
                }});
            }

            for (final CmsResource resource : allResources) {
                ResourceItem item = new ResourceItem() {{
                    setResource(resource);
                }};

                if (resource.getParentId() == null || resource.getParentId() == 0) {
                    menus.add(item);
                } else {
                    ResourceItem parentResource = map.get(resource.getParentId());
                    if (parentResource == null) {
                        menus.add(item);
                    } else {
                        if (parentResource.getChildren() == null) {
                            parentResource.setChildren(new ArrayList<ResourceItem>());
                        }
                        parentResource.getChildren().add(item);
                    }
                }
            }
        }

        return menus;
    }

    @Override
    public List<CmsResource> findByUserId(int userId) {
        return resourceMapper.findByUserId(userId);
    }

    @Override
    public Set<Integer> findResourceIdsByUserId(int userId) {
        List<CmsResource> resources = findByUserId(userId);
        if (resources == null || resources.isEmpty()) {
            return null;
        }

        Set<Integer> ids = new HashSet<Integer>();
        for (CmsResource resource : resources) {
            ids.add(resource.getResourceId());
        }
        return ids;
    }
}
