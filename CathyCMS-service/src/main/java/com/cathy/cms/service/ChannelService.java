package com.cathy.cms.service;

import com.data.pojo.CmsChannel;

import java.util.List;

/**
 * Created by 陈敬 on 17/9/26.
 */
public interface ChannelService {
    List<CmsChannel> findByLevel(String level);

    CmsChannel findByChannelId(Integer id);

    void insert(CmsChannel channel);

    void update(CmsChannel channel);
}
