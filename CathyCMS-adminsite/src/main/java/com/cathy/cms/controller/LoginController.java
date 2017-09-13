package com.cathy.cms.controller;

import com.cathy.cms.utils.WebHelper;
import com.data.model.ResourceItem;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cms.cathy.common.utils.Md5Util;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 陈敬 on 17/8/30.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
//    private UserService userService;

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("name","chenjing");
        return "login";
    }


    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpSession session){
        boolean rememberMe = false;

        String md5Pwd = Md5Util.generatePassword(password);

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, md5Pwd, rememberMe);

            Subject subject = SecurityUtils.getSubject();

            subject.login(token);

            //跳转第一个菜单
            List<ResourceItem> hasResource = (List<ResourceItem>) session.getAttribute(WebHelper.SESSION_MENU_RESOURCE);
            if(hasResource != null && !hasResource.isEmpty()){
                for(ResourceItem resource : hasResource){

                    List<ResourceItem> chResources = resource.getChildren();
                    if(StringUtils.isNotBlank(resource.getResource().getUrl()) && (chResources == null || chResources.isEmpty())){
                        return "redirect:" + resource.getResource().getUrl();
                    }
                    if(chResources != null && !chResources.isEmpty()){
                        for(ResourceItem chRes : chResources){
                            if(StringUtils.isNotBlank(chRes.getResource().getUrl())){
                                return "redirect:" + chRes.getResource().getUrl();
                            }
                        }
                    }
                }
            }

            return "redirect:/user/list";
        } catch (LockedAccountException lae) {
			lae.printStackTrace();
            model.addAttribute("msg", "账号已被禁用");
        } catch (AuthenticationException ae) {
			ae.printStackTrace();
            model.addAttribute("msg", "账号或密码错误");
        } catch (Exception e) {
			e.printStackTrace();
            model.addAttribute("msg", "登录异常");
        }

        return "login";
    }
}
