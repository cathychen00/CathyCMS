package com.cathy.cms.service.impl;

import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.service.ChannelService;
import com.data.mapper.CmsChannelMapper;
import com.data.pojo.CmsChannel;
import com.data.pojo.CmsChannelCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 陈敬 on 17/9/26.
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    CmsChannelMapper channelMapper;

    @Override
    public List<CmsChannel> findByLevel(String level) {
        CmsChannelCriteria criteria=new CmsChannelCriteria();
        criteria.createCriteria().andIsdelEqualTo(ConstantHelper.DELETE_FLAG_NORMAL).andLevelEqualTo(level);
        criteria.setOrderByClause(" orderNum asc ");
        return channelMapper.selectByExample(criteria);
    }

    @Override
    public CmsChannel findByChannelId(Integer id) {
        CmsChannelCriteria criteria=new CmsChannelCriteria();
        criteria.createCriteria().andIdEqualTo(id);

        List<CmsChannel> list=channelMapper.selectByExample(criteria);
        if(list==null||list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public void insert(CmsChannel channel) {
        if(channel==null){
            return ;
        }

        Date currentTime=new Date();
        channel.setCreateTime(currentTime);
        channel.setUpdateTime(currentTime);
        channel.setIsDel(ConstantHelper.DELETE_FLAG_NORMAL);

        channelMapper.insert(channel);
    }

    @Override
    public void update(CmsChannel channel) {
        if(channel==null){
            return ;
        }

        CmsChannel updateChannel=findByChannelId(channel.getId());
        if(updateChannel==null){
            return ;
        }

        updateChannel.setUpdateTime(new Date());
        updateChannel.setChannelName(channel.getChannelName());
        updateChannel.setIcon(channel.getIcon());
        updateChannel.setOrderNum(channel.getOrderNum());

        channelMapper.updateByPrimaryKey(updateChannel);
    }

    @Override
    public int delete(int id) {
        CmsChannel channel=findByChannelId(id);
        if(channel==null){
            return -1;
        }

        channel.setIsDel(ConstantHelper.DELETE_FLAG_DELETED);

        return channelMapper.updateByPrimaryKey(channel);
    }
}
