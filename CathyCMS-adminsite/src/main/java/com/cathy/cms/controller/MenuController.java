package com.cathy.cms.controller;

import cms.cathy.common.utils.ConstantHelper;
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

    /**
     * 菜单列表
     * @param model
     */
    @RequestMapping("/index")
    public String index(Model model) {

        //todo:补全菜单parent数据
        List<CmsResource> resources = resourceService.listAllResources();
        model.addAttribute("resources", resources);

        List<CmsResource> modules=resourceService.listResourcesByType(ConstantHelper.RESOURCE_TYPE_MODULE);
        model.addAttribute("modules",modules);

        return "/menu/index";
    }

    /**
     * 保存菜单
     * @param resource 菜单详情
     */
    @RequestMapping("save")
    public String save(CmsResource resource){
        if(resource.getResourceId()==null||resource.getResourceId()==0){
            resource.setDeleteFlag("0");
            resourceService.insertResource(resource);
        }else{
            resourceService.updateResource(resource);
        }

        return "/menu/index";
    }
}
