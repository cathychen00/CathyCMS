package com.cathy.cms.service.impl;

import cms.cathy.common.utils.DateUtils;
import com.cathy.cms.dto.ArticleQueryDTO;
import com.cathy.cms.service.ArticleService;
import com.cathy.common.models.PageModel;
import com.data.mapper.CmsArticlesMapper;
import com.data.pojo.CmsArticles;
import com.data.pojo.CmsArticlesCriteria;
import org.apache.ibatis.session.RowBounds;
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

    @Override
    public PageModel<CmsArticles> findArticlesPaging(ArticleQueryDTO queryDTO) {

        PageModel<CmsArticles> pageModel=new PageModel<CmsArticles>();
        pageModel.setPageIndex(queryDTO.getPageIndex());
        pageModel.setPageSize(queryDTO.getPageSize());

        CmsArticlesCriteria criteria=new CmsArticlesCriteria();
        if(queryDTO!=null){
            criteria.or()
                    .andIsAuditEqualTo(queryDTO.getAudit())
                    .andIsDeleteEqualTo(queryDTO.getDelete())
                    .andIsTopEqualTo(queryDTO.getTop())
                    .andChannel1EqualTo(queryDTO.getChannel1())
                    .andChannel2EqualTo(queryDTO.getChannel2())
                    .andPublisherLike(queryDTO.getPublisher())
                    .andAdminIdEqualTo(queryDTO.getAdminId())
                    .andTitleLike(queryDTO.getTitle());

            if(queryDTO.getPublishTimeStart()!=null){
                Date publishTimeStart= DateUtils.getStartDate(queryDTO.getPublishTimeStart());
                criteria.or().andPublishTimeGreaterThan(publishTimeStart);
            }

            if(queryDTO.getPublishTimeEnd()!=null){
                Date publishTimeEnd=DateUtils.getEndDate(queryDTO.getPublishTimeEnd());
                criteria.or().andPublishTimeLessThan(publishTimeEnd);
            }
        }

        RowBounds rowBounds=new RowBounds((queryDTO.getPageIndex()-1)*queryDTO.getPageSize(),queryDTO.getPageSize());
        List<CmsArticles> articles=articlesMapper.selectByExampleWithRowbounds(criteria,rowBounds);
        pageModel.setItems(articles);

        return pageModel;
    }

}
