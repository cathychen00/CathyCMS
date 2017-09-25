package com.cathy.cms.controller;

import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.service.RoleService;
import com.cathy.cms.service.UserService;
import com.cathy.cms.utils.WebHelper;
import com.cathy.common.models.PageModel;
import com.data.model.UserQueryDTO;
import com.data.pojo.CmsRole;
import com.data.pojo.CmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 陈敬 on 17/9/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final Integer PAGE_SIZE=10;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/list")
    public String list(UserQueryDTO queryDTO, Model model){
        if(queryDTO==null){
            queryDTO=new UserQueryDTO();
        }
        queryDTO.setPageSize(PAGE_SIZE);

        int totalCount=userService.count(queryDTO);
        //todo：补全用户角色
        PageModel<CmsUser> pageModel=userService.findUsersPaging(queryDTO);
        pageModel.setTotalCount(totalCount);

        model.addAttribute("query",queryDTO);
        model.addAttribute("pageModel",pageModel);
        return "/user/list";
    }

    @RequestMapping("/edit")
    public String edit(Integer userId,Model model){
        CmsUser user;
        String pageTitle="";
        if(userId==null||userId==0){
            user=new CmsUser();
            pageTitle="新增用户";
        }else{
            user=userService.findByUserId(userId);
            pageTitle="编辑用户";
        }
        model.addAttribute("user",user);
        model.addAttribute("pageTitle",pageTitle);

        List<CmsRole> roles=roleService.listAllRoles(ConstantHelper.DELETE_FLAG_NORMAL);
        model.addAttribute("roles",roles);

        return "/user/edit";
    }

    @RequestMapping("/update_pwd")
    public String updatePassword(Model model, HttpSession session){
        session.setAttribute("test1","test1");
        return "/user/updatePwd";
    }
}
