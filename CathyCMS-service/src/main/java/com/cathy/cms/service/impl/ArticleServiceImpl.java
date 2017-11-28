package com.cathy.cms.service.impl;

import cms.cathy.common.utils.DateUtils;
import com.cathy.cms.dto.ArticleQueryDTO;
import com.cathy.cms.dto.ArticleWrapper;
import com.cathy.cms.service.ArticleService;
import com.cathy.cms.service.ChannelService;
import com.cathy.common.models.PageModel;
import com.data.mapper.CmsArticlesMapper;
import com.data.mapper.CmsChannelMapper;
import com.data.pojo.CmsArticles;
import com.data.pojo.CmsArticlesCriteria;
import com.data.pojo.CmsChannel;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ref.WeakReference;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈敬 on 17/9/28.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    CmsArticlesMapper articlesMapper;
    @Autowired
    ChannelService channelService;

    @Override
    public void insert(CmsArticles article) {
        Date currentTime = new Date();
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
        CmsArticles updateArticle = findById(article.getId());
        if (updateArticle == null) {
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
        CmsArticlesCriteria criteria = new CmsArticlesCriteria();
        criteria.createCriteria().andIdEqualTo(id);

        List<CmsArticles> list = articlesMapper.selectByExample(criteria);
        if (list == null || list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public PageModel<ArticleWrapper> findArticlesPaging(ArticleQueryDTO queryDTO) {

        PageModel<ArticleWrapper> pageModelResult = new PageModel<ArticleWrapper>();
        pageModelResult.setPageIndex(queryDTO.getPageIndex());
        pageModelResult.setPageSize(queryDTO.getPageSize());

        //set total count
        int totalCount=count(queryDTO);
        pageModelResult.setTotalCount(totalCount);

        CmsArticlesCriteria criteria = buildCritia(queryDTO);
        RowBounds rowBounds = new RowBounds((queryDTO.getPageIndex() - 1) * queryDTO.getPageSize(), queryDTO.getPageSize());
        List<CmsArticles> articles = articlesMapper.selectByExampleWithRowbounds(criteria, rowBounds);

        List<ArticleWrapper> articleWrappers=new ArrayList<ArticleWrapper>();
        if(articles!=null){
            for(CmsArticles article:articles){
                ArticleWrapper wrapper=new ArticleWrapper();
                wrapper.setId(article.getId());
                wrapper.setArticleInfo(article);

                //fill channel
                if(article.getChannel1()!=null&&article.getChannel1()>0){
                    CmsChannel channel1=channelService.findByChannelId(article.getChannel1());
                    wrapper.setChannel1(channel1);

                    if(article.getChannel2()!=null&&article.getChannel2()>0){
                        CmsChannel channel2=channelService.findByChannelId(article.getChannel2());
                        wrapper.setChannel2(channel2);
                    }
                }

                articleWrappers.add(wrapper);
            }
        }
        //set items
        pageModelResult.setItems(articleWrappers);

        return pageModelResult;
    }

    @Override
    public int count(ArticleQueryDTO queryDto) {
        CmsArticlesCriteria criteria = buildCritia(queryDto);
        return articlesMapper.countByExample(criteria);
    }

    @Override
    public int delete(int articleId) {
        return articlesMapper.updateDeleteFlag(articleId,true);
    }

    @Override
    public int reset(int articleId) {
        return articlesMapper.updateDeleteFlag(articleId,false);
    }

    private CmsArticlesCriteria buildCritia(ArticleQueryDTO queryDto) {
        CmsArticlesCriteria criteria = new CmsArticlesCriteria();
        if (queryDto != null) {
            if (queryDto.getChannel1() != null&&queryDto.getChannel1()>0) {
                criteria.or().andChannel1EqualTo(queryDto.getChannel1());
                if (queryDto.getChannel2() != null&&queryDto.getChannel2()>0) {
                    criteria.or().andChannel2EqualTo(queryDto.getChannel2());
                }
            }
            if (queryDto.getAudit() != null) {
                criteria.or().andIsAuditEqualTo(queryDto.getAudit());
            }
            if (queryDto.getDelete() != null) {
                criteria.or().andIsDeleteEqualTo(queryDto.getDelete());
            }
            if (queryDto.getTop() != null) {
                criteria.or().andIsTopEqualTo(queryDto.getTop());
            }
            if (StringUtils.isNotBlank(queryDto.getPublisher())) {
                criteria.or().andPublisherLike(queryDto.getPublisher());
            }
            if (StringUtils.isNotBlank(queryDto.getTitle())) {
                criteria.or().andTitleLike(queryDto.getTitle());
            }
            if (StringUtils.isNotBlank(queryDto.getPublishTimeStart())) {
                Date publishTimeStart = DateUtils.getStartDate(queryDto.getPublishTimeStart());
                criteria.or().andPublishTimeGreaterThan(publishTimeStart);
            }
            if (StringUtils.isNotBlank(queryDto.getPublishTimeEnd())) {
                Date publishTimeEnd = DateUtils.getEndDate(queryDto.getPublishTimeEnd());
                criteria.or().andPublishTimeLessThan(publishTimeEnd);
            }
        }
        return criteria;
    }
}
