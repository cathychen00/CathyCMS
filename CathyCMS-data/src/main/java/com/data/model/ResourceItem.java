package com.data.model;

import com.data.pojo.CmsResource;
import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

import java.util.List;

/**
 * Created by 陈敬 on 17/9/13.
 * 权限资源实体
 */
public class ResourceItem{

    CmsResource currentResource;
    List<ResourceItem> children;

    public CmsResource getCurrentResource() {
        return currentResource;
    }

    public void setCurrentResource(CmsResource currentResource) {
        this.currentResource = currentResource;
    }

    public List<ResourceItem> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceItem> children) {
        this.children = children;
    }
}
