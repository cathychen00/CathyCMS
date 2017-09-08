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

//    @RequestMapping(value = "/loginCheck.html")
//    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
//        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(),
//                loginCommand.getPassword());
//        if (!isValidUser) {
//            return new ModelAndView("login", "error", "用户名或密码错误。");
//        } else {
//            User user = userService.findUserByUserName(loginCommand
//                    .getUserName());
//            user.setLastIp(request.getLocalAddr());
//            user.setLastVisit(new Date());
//            userService.loginSuccess(user);
//            request.getSession().setAttribute("user", user);
//            return new ModelAndView("main");
//        }
//    }
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
