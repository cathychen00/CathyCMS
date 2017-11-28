package com.cathy.cms.controller;

import cms.cathy.common.utils.ConstantHelper;
import com.cathy.cms.dto.ArticleQueryDTO;
import com.cathy.cms.dto.ArticleWrapper;
import com.cathy.cms.service.ArticleService;
import com.cathy.cms.service.ChannelService;
import com.cathy.cms.utils.WebHelper;
import com.cathy.common.models.JsonResult;
import com.cathy.common.models.PageModel;
import com.data.pojo.CmsArticles;
import com.data.pojo.CmsChannel;
import com.data.pojo.CmsUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    private static final int DEFAULT_PAGE_INDEX = 1;
    private static final int DEFAULT_PAGE_SIZE = 20;

    @RequestMapping("/edit")
    public String edit(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id, Model model) {
        List<CmsChannel> channels1 = channelService.findByLevel(ConstantHelper.CHANNEL_LEVEL1);
        model.addAttribute("channels1", channels1);

        String pageTitle;
        CmsArticles article;
        if (id == null || id.equals(0)) {
            pageTitle = "新增文章";
            article = new CmsArticles();
        } else {
            pageTitle = "编辑文章";
            article = articleService.findById(id);

            if (article.getChannel1() != null) {
                List<CmsChannel> channels2 = channelService.findByParent(article.getChannel1());
                model.addAttribute("channels2", channels2);
            }
        }

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("article", article);

        return "/article/edit";
    }

    @RequestMapping(value = "/ajaxSave", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(CmsArticles article, HttpSession session) {
        JsonResult jsonResult = validateArticle(article);
        if (jsonResult.getReturncode() != 0) {
            return jsonResult;
        }

        CmsUser currentUser = (CmsUser) session.getAttribute(WebHelper.SESSION_LOGIN_USER);
        article.setAdminId(currentUser.getUserId());
        article.setAdminName(currentUser.getUsername());
        article.setPublisher(currentUser.getRealName());

        if (article.getId() == null || article.getId().equals(0)) {
            articleService.insert(article);
        } else {
            articleService.update(article);
        }
        jsonResult.setReturncode(0);
        jsonResult.setResult(article.getId());

        return jsonResult;
    }

    @RequestMapping("/list")
    public String list(ArticleQueryDTO queryDto, Model model) {
        //pate title
        model.addAttribute("pageTitle", "文章列表");

        //query dto
        if (queryDto == null) {
            queryDto = new ArticleQueryDTO();
            queryDto.setPageIndex(DEFAULT_PAGE_INDEX);
        }
        queryDto.setPageSize(DEFAULT_PAGE_SIZE);
        model.addAttribute("queryDto", queryDto);

        //channel list
        List<CmsChannel> channels1 = channelService.findByLevel(ConstantHelper.CHANNEL_LEVEL1);
        model.addAttribute("channels1", channels1);

        if (queryDto.getChannel1() != null) {
            List<CmsChannel> channels2 = channelService.findByParent(queryDto.getChannel1());
            model.addAttribute("channels2", channels2);
        }

        //article list
        PageModel<ArticleWrapper> pageModel = articleService.findArticlesPaging(queryDto);
        model.addAttribute("pageModel", pageModel);

        return "/article/list";
    }

    @RequestMapping(value = "/ajaxDelete")
    @ResponseBody
    public int delete(@RequestParam("articleId") int articleId) {
        return articleService.delete(articleId);
    }

    @RequestMapping(value = "/ajaxReset")
    @ResponseBody
    public int reset(@RequestParam("articleId") int articleId) {
        return articleService.reset(articleId);
    }

    private JsonResult validateArticle(CmsArticles article) {
        JsonResult jsonResult = new JsonResult() {{
            setReturncode(0);
            setMessage("");
        }};

        if (article == null) {
            jsonResult.setReturncode(-1);
            jsonResult.setMessage("文章实体不能为null");
        } else if (StringUtils.isBlank(article.getTitle())) {
            jsonResult.setReturncode(-1);
            jsonResult.setMessage("标题不能为空");
        } else if (StringUtils.isBlank(article.getContent())) {
            jsonResult.setReturncode(-1);
            jsonResult.setMessage("正文不能为空");
        } else if (article.getPublishTime() == null) {
            jsonResult.setReturncode(-1);
            jsonResult.setMessage("请选择发布时间");
        }

        return jsonResult;
    }
}
