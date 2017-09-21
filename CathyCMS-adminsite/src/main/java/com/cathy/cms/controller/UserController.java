package com.cathy.cms.controller;

import com.cathy.cms.service.UserService;
import com.cathy.cms.utils.WebHelper;
import com.cathy.common.models.PageModel;
import com.data.model.UserQueryDTO;
import com.data.pojo.CmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 陈敬 on 17/9/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final Integer PAGE_SIZE=10;

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public String list(UserQueryDTO queryDTO, Model model){
        if(queryDTO==null){
            queryDTO=new UserQueryDTO();
        }
        queryDTO.setPageSize(PAGE_SIZE);

        int totalCount=userService.count(queryDTO);
        PageModel<CmsUser> pageModel=userService.findUsersPaging(queryDTO);
        pageModel.setTotalCount(totalCount);

        model.addAttribute("query",queryDTO);
        model.addAttribute("pageModel",pageModel);
        return "/user/list";
    }

    @RequestMapping("/update_pwd")
    public String updatePassword(Model model, HttpSession session){
        session.setAttribute("test1","test1");
        return "/user/updatePwd";
    }
}
