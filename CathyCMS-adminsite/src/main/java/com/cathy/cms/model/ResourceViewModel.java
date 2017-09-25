package com.cathy.cms.model;

import com.data.pojo.CmsResource;

/**
 * Created by 陈敬 on 17/9/25.
 */
public class ResourceViewModel {
    CmsResource mainInfo;
    CmsResource parent;

    public CmsResource getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(CmsResource mainInfo) {
        this.mainInfo = mainInfo;
    }

    public CmsResource getParent() {
        return parent;
    }

    public void setParent(CmsResource parent) {
        this.parent = parent;
    }
}
