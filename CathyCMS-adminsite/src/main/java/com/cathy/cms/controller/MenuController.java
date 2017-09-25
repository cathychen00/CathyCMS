package com.cathy.cms.controller;

import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.model.ResourceViewModel;
import com.cathy.cms.service.ResourceService;
import com.data.pojo.CmsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
     *
     * @param model
     */
    @RequestMapping("/index")
    public String index(Model model) {
        List<ResourceViewModel> list=new ArrayList<>();
        List<CmsResource> resources = resourceService.listAllResources();
        if(resources!=null&&!resources.isEmpty()) {
            for (CmsResource r : resources) {
                ResourceViewModel item = new ResourceViewModel();
                item.setMainInfo(r);

                if (r.getParentId() != null) {
                    CmsResource parent = resourceService.findByResourceId(r.getParentId());
                    item.setParent(parent);
                }

                list.add(item);
            }
            model.addAttribute("resources", list);
        }

        return "/menu/index";
    }

    @RequestMapping("/editPanel")
    public String editPanel(Integer resourceId, Model model) {

        //菜单详情
        CmsResource resource;
        String panelName;
        if (resourceId == null || resourceId == 0) {
            resource = new CmsResource();
            panelName = "增加菜单";
        } else {
            resource = resourceService.findByResourceId(resourceId);
            panelName = "编辑菜单";
        }

        model.addAttribute("resource", resource);
        model.addAttribute("panelName", panelName);

        //模块列表
        List<CmsResource> modules = resourceService.listResourcesByType(ConstantHelper.RESOURCE_TYPE_MODULE);
        model.addAttribute("modules", modules);

        return "/menu/editPanel";
    }

    /**
     * 保存菜单
     *
     * @param resource 菜单详情
     */
    @RequestMapping("save")
    public String save(CmsResource resource) {
        if (resource.getResourceId() == null || resource.getResourceId() == 0) {
            resource.setDeleteFlag("0");
            resourceService.insertResource(resource);
        } else {
            resourceService.updateResource(resource);
        }

        return "redirect:/menu/index";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(int id) {
        resourceService.deleteResource(id);
    }

    @RequestMapping("/reset")
    @ResponseBody
    public void reset(int id) {
        resourceService.resetResource(id);
    }
}
