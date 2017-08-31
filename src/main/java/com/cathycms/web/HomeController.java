package com.cathycms.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 陈敬 on 17/8/31.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String index(Model model){
        model.addAttribute("name","chenjing");
        return "index";
    }
}
