package com.cathy.cms.service;

import com.cathy.cms.dto.ArticleQueryDTO;
import com.cathy.common.models.PageModel;
import com.data.pojo.CmsArticles;

/**
 * Created by 陈敬 on 17/9/28.
 */
public interface ArticleService {
    void insert(CmsArticles article);

    void update(CmsArticles article);

    CmsArticles findById(Integer id);

    PageModel<CmsArticles> findArticlesPaging(ArticleQueryDTO queryDTO);
}
