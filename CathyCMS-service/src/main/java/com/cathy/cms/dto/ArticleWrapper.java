package com.cathy.cms.dto;

import com.data.pojo.CmsArticles;
import com.data.pojo.CmsChannel;

/**
 * @author 陈敬
 * @date 17/11/28
 */
public class ArticleWrapper {
    private Integer id;
    private CmsArticles articleInfo;
    private CmsChannel channel1;
    private CmsChannel channel2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CmsArticles getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(CmsArticles articleInfo) {
        this.articleInfo = articleInfo;
    }

    public CmsChannel getChannel1() {
        return channel1;
    }

    public void setChannel1(CmsChannel channel1) {
        this.channel1 = channel1;
    }

    public CmsChannel getChannel2() {
        return channel2;
    }

    public void setChannel2(CmsChannel channel2) {
        this.channel2 = channel2;
    }
}
