package com.cathy.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 陈敬 on 17/9/26.
 * 频道管理
 */
@Controller
@RequestMapping("/channel")
public class ChannelController {

    @RequestMapping("/list")
    public String list(Model model){
        return "/channel/list";
    }
}
