package com.cathy.cms.web;

//import com.cathy.cms.domain.User;
//import com.cathy.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 陈敬 on 17/8/30.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
//    private UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("name","chenjing");
        return "login";
    }


    @RequestMapping("/doLogin")
    public String doLogin(String username,String password){
        return "index";
    }
}
