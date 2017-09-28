package com.cathy.cms.controller;

import com.data.pojo.CmsArticles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 陈敬 on 17/9/28.
 * 文章列表
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @RequestMapping("/edit")
    public String edit(@RequestParam(value = "id",required = false,defaultValue = "0")Integer id,Model model){
        String pageTitle;
        CmsArticles article;
        if(id==null||id.equals(0)){
         pageTitle="新增文章";
         article=new CmsArticles();
        }else{
            pageTitle="编辑文章";
            article=new CmsArticles();//todo:getArticleById
        }
        model.addAttribute("pageTitle",pageTitle);
        model.addAttribute("article",article);

        return "/article/edit";
    }
}
