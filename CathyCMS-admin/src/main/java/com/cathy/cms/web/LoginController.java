package com.cathy.cms.web;

//import com.cathy.cms.domain.User;
//import com.cathy.cms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import utils.Md5Util;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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
    public String doLogin(String username,String password,Model model){
        boolean rememberMe = false;

        String md5Pwd = Md5Util.generatePassword(password);

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, md5Pwd, rememberMe);

            Subject subject = SecurityUtils.getSubject();

            subject.login(token);

//            //跳转第一个菜单
//            List<Resource> hasResource = (List<Resource>) request.getSession().getAttribute(WebHelper.SESSION_MENU_RESOURCE);
//            if(hasResource != null && !hasResource.isEmpty()){
//                for(Resource resource : hasResource){
//
//                    List<Resource> chResources = resource.getChildren();
//                    if(StringUtils.isNotBlank(resource.getUrl()) && (chResources == null || chResources.isEmpty())){
//                        return "redirect:" + resource.getUrl();
//                    }
//                    if(chResources != null && !chResources.isEmpty()){
//                        for(Resource chRes : chResources){
//                            if(StringUtils.isNotBlank(chRes.getUrl())){
//                                return "redirect:" + chRes.getUrl();
//                            }
//                        }
//                    }
//                }
//            }

            return "redirect:/user/list";
        } catch (LockedAccountException lae) {
//			lae.printStackTrace();
            model.addAttribute("msg", "账号已被禁用");
        } catch (AuthenticationException ae) {
//			ae.printStackTrace();
            model.addAttribute("msg", "账号或密码错误");
        } catch (Exception e) {
//			e.printStackTrace();
            model.addAttribute("msg", "登录异常");
        }

        return "login";
    }
}
