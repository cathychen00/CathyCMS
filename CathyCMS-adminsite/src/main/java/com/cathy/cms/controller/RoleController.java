package com.cathy.cms.controller;

import com.cathy.cms.service.RoleService;
import com.cathy.common.models.JsonResult;
import com.data.pojo.CmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 陈敬 on 17/9/18.
 * 角色管理
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 角色列表
     */
    @RequestMapping("/list")
    public String list(Model model){

        List<CmsRole> roles=roleService.listAllRoles();
        model.addAttribute("roles",roles);

        return "/role/list";
    }

    /**
     * 删除角色
     * @param roleId 角色id
     * @return jsonResult.returncode=0表示成功
     */
    @RequestMapping("delete")
    @ResponseBody
    public JsonResult delete(int roleId){
        JsonResult jsonResult=new JsonResult(){{
            setReturncode(-1);
        }};
        int result=roleService.deleteByRoleId(roleId);
        if(result>0){
            jsonResult.setReturncode(0);
        }

        return jsonResult;
    }

    /**
     * 恢复角色
     * @param roleId 角色id
     * @return jsonResult.returncode=0表示成功
     */
    @RequestMapping("reset")
    @ResponseBody
    public JsonResult reset(int roleId){
        JsonResult jsonResult=new JsonResult(){{
            setReturncode(-1);
        }};
        int result=roleService.resetByRoleId(roleId);
        if(result>0){
            jsonResult.setReturncode(0);
        }

        return jsonResult;
    }

    /**
     * 新增/修改角色
     * @param roleId 角色id
     */
    @RequestMapping("/edit")
    public String edit(Integer roleId,Model model){
        CmsRole role;
        String menu;
        if(roleId==null){
            role=new CmsRole();
            menu="新增角色";
        }else{
            role=roleService.findByRoleId(roleId);
            menu="编辑角色";
        }
        model.addAttribute("role",role);
        model.addAttribute("menu",menu);

        return "/role/edit";
    }

    /**
     * 保存角色
     * @param role 角色实体
     * @return jsonResult.returncode=0表示成功
     */
    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(CmsRole role){
        JsonResult jsonResult=new JsonResult(){{
            setReturncode(-1);
            setMessage("保存失败");
        }};

        int result;
        if(role.getRoleId()==null||role.getRoleId()==0){
            result=roleService.insert(role);
        }else{
            result=roleService.update(role);
        }

        if(result>0){
            jsonResult.setReturncode(0);
            jsonResult.setMessage("保存成功");
        }

        return jsonResult;
    }
}
