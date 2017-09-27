package com.cathy.cms.controller;

import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.service.ChannelService;
import com.data.pojo.CmsChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 陈敬 on 17/9/26.
 * 频道管理
 */
@Controller
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    ChannelService channelService;

    @RequestMapping("/list")
    public String list(@RequestParam(name = "parentId",required = false,defaultValue = "0")Integer parentId, Model model){
        List<CmsChannel> channelParents=channelService.findByLevel(ConstantHelper.CHANNEL_LEVEL1);
        model.addAttribute("parents",channelParents);
        model.addAttribute("parentId",parentId);
        return "/channel/list";
    }

    @RequestMapping("/ajaxSave")
    @ResponseBody
    public int ajaxSave(CmsChannel channel){
        if(channel==null){
            return -1;
        }

        if(channel.getId()==null||channel.getId()==0){
            channelService.insert(channel);
        }else{
            channelService.update(channel);
        }

        return channel.getId();
    }

    @RequestMapping("/ajaxDelete")
    @ResponseBody
    public int ajaxDelete(int id){
        return channelService.delete(id);
    }
}
