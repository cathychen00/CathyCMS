package com.cathy.cms.controller;

import com.cathy.cms.service.ResourceService;
import com.data.pojo.CmsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 陈敬 on 17/9/15.
 * 菜单管理
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    ResourceService resourceService;

    @RequestMapping("/index")
    public String index(Model model) {

        //todo:补全菜单parent数据
        List<CmsResource> resources = resourceService.listAllResources();
        model.addAttribute("resources", resources);

        return "/menu/index";
    }
}
