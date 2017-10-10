package com.cathy.cms.service.impl;

import com.cathy.cms.service.ArticleService;
import com.data.mapper.CmsArticlesMapper;
import com.data.pojo.CmsArticles;
import com.data.pojo.CmsArticlesCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 陈敬 on 17/9/28.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    CmsArticlesMapper articlesMapper;

    @Override
    public void insert(CmsArticles article) {
        Date currentTime=new Date();
        article.setCreateTime(currentTime);
        article.setUpdateTime(currentTime);
        article.setIsAudit(false);
        article.setIsDelete(false);
        article.setIsTop(false);
        article.setIsDraft(false);
        article.setPcPv(0);

        articlesMapper.insert(article);
    }

    @Override
    public void update(CmsArticles article) {
        CmsArticles updateArticle=findById(article.getId());
        if(updateArticle==null){
            return;
        }

        updateArticle.setTitle(article.getTitle());
        updateArticle.setChannel1(article.getChannel1());
        updateArticle.setChannel2(article.getChannel2());
        updateArticle.setContent(article.getContent());
        updateArticle.setCoverImage(article.getCoverImage());
        updateArticle.setSummary(article.getSummary());
        updateArticle.setUpdateTime(new Date());
        updateArticle.setPublishTime(article.getPublishTime());
        updateArticle.setAdminId(article.getAdminId());
        updateArticle.setAdminName(article.getAdminName());
        updateArticle.setPublisher(article.getPublisher());

        articlesMapper.update(updateArticle);
    }

    @Override
    public CmsArticles findById(Integer id) {
        CmsArticlesCriteria criteria=new CmsArticlesCriteria();
        criteria.createCriteria().andIdEqualTo(id);

        List<CmsArticles> list=articlesMapper.selectByExample(criteria);
        if(list==null||list.isEmpty()){
            return null;
        }

        return list.get(0);
    }
}
