package com.data.model;

import com.data.pojo.CmsResource;

import java.util.List;

/**
 * Created by 陈敬 on 17/9/13.
 * 权限资源实体
 */
public class ResourceItem{

    CmsResource resource;
    List<ResourceItem> children;

    public CmsResource getResource() {
        return resource;
    }

    public void setResource(CmsResource resource) {
        this.resource = resource;
    }

    public List<ResourceItem> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceItem> children) {
        this.children = children;
    }
}
