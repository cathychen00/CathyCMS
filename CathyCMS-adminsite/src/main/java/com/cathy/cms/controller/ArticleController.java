package com.cathy.cms.controller;

import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.service.ArticleService;
import com.cathy.cms.service.ChannelService;
import com.data.pojo.CmsArticles;
import com.data.pojo.CmsChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 陈敬 on 17/9/28.
 * 文章列表
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ChannelService channelService;

    @Autowired
    ArticleService articleService;

    @RequestMapping("/edit")
    public String edit(@RequestParam(value = "id",required = false,defaultValue = "0")Integer id,Model model){
        List<CmsChannel> channels1=channelService.findByLevel(ConstantHelper.CHANNEL_LEVEL1);
        model.addAttribute("channels1",channels1);

        String pageTitle;
        CmsArticles article;
        if(id==null||id.equals(0)){
         pageTitle="新增文章";
         article=new CmsArticles();
        }else{
            pageTitle="编辑文章";
            article=new CmsArticles();//todo:getArticleById
            if(article.getChannel1()>0){
                List<CmsChannel> channels2=channelService.findByParent(article.getChannel1());
                model.addAttribute("channels2",channels2);
            }
        }
        model.addAttribute("pageTitle",pageTitle);
        model.addAttribute("article",article);



        return "/article/edit";
    }
}
