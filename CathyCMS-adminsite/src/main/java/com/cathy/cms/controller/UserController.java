package com.cathy.cms.controller;

import com.cathy.cms.utils.WebHelper;
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

    @RequestMapping("/list")
    public String list(Model model){
        return "/user/list";
    }

    @RequestMapping("/update_pwd")
    public String updatePassword(Model model, HttpSession session){
        session.setAttribute("test1","test1");
        return "/user/updatePwd";
    }
}
