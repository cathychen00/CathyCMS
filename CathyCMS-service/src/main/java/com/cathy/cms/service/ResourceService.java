package com.cathy.cms.service;

import com.data.model.ResourceItem;
import com.data.pojo.CmsResource;

import java.util.List;
import java.util.Set;

/**
 * Created by 陈敬 on 17/9/8.
 */
public interface ResourceService {
    Set<CmsResource> findByRoleId(Integer roleId);

    /**
     * 获取全部功能菜单
     */
    List<ResourceItem> findAllMenu();

    List<CmsResource> findByUserId(int userId);

    Set<Integer> findResourceIdsByUserId(int userId);
}
