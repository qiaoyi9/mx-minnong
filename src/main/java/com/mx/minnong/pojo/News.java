package com.mx.minnong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class News {
    @Id
    @Column(name = "news_id")
    private Integer newsId;

    /**
     * 新闻标题
     */
    @Column(name = "news_title")
    private String newsTitle;

    /**
     * 新闻发布人
     */
    @Column(name = "news_author")
    private String newsAuthor;

    /**
     * 新闻来源
     */
    @Column(name = "news_source")
    private String newsSource;

    /**
     * 新闻头图
     */
    @Column(name = "news_picture")
    private String newsPicture;

    /**
     * 浏览量
     */
    @Column(name = "news_pageviews")
    private Integer newsPageviews;

    /**
     * 创建时间
     */
    @Column(name = "news_createTime")
    private Date newsCreatetime;

    /**
     * 修改时间
     */
    @Column(name = "news_updateTime")
    private Date newsUpdatetime;

    /**
     * 新闻内容
     */
    @Column(name = "news_content")
    private String newsContent;

    /**
     * @return news_id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * @param newsId
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * 获取新闻标题
     *
     * @return news_title - 新闻标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 设置新闻标题
     *
     * @param newsTitle 新闻标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * 获取新闻发布人
     *
     * @return news_author - 新闻发布人
     */
    public String getNewsAuthor() {
        return newsAuthor;
    }

    /**
     * 设置新闻发布人
     *
     * @param newsAuthor 新闻发布人
     */
    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    /**
     * 获取新闻来源
     *
     * @return news_source - 新闻来源
     */
    public String getNewsSource() {
        return newsSource;
    }

    /**
     * 设置新闻来源
     *
     * @param newsSource 新闻来源
     */
    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    /**
     * 获取新闻头图
     *
     * @return news_picture - 新闻头图
     */
    public String getNewsPicture() {
        return newsPicture;
    }

    /**
     * 设置新闻头图
     *
     * @param newsPicture 新闻头图
     */
    public void setNewsPicture(String newsPicture) {
        this.newsPicture = newsPicture;
    }

    /**
     * 获取浏览量
     *
     * @return news_pageviews - 浏览量
     */
    public Integer getNewsPageviews() {
        return newsPageviews;
    }

    /**
     * 设置浏览量
     *
     * @param newsPageviews 浏览量
     */
    public void setNewsPageviews(Integer newsPageviews) {
        this.newsPageviews = newsPageviews;
    }

    /**
     * 获取创建时间
     *
     * @return news_createTime - 创建时间
     */
    public Date getNewsCreatetime() {
        return newsCreatetime;
    }

    /**
     * 设置创建时间
     *
     * @param newsCreatetime 创建时间
     */
    public void setNewsCreatetime(Date newsCreatetime) {
        this.newsCreatetime = newsCreatetime;
    }

    /**
     * 获取修改时间
     *
     * @return news_updateTime - 修改时间
     */
    public Date getNewsUpdatetime() {
        return newsUpdatetime;
    }

    /**
     * 设置修改时间
     *
     * @param newsUpdatetime 修改时间
     */
    public void setNewsUpdatetime(Date newsUpdatetime) {
        this.newsUpdatetime = newsUpdatetime;
    }

    /**
     * 获取新闻内容
     *
     * @return news_content - 新闻内容
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 设置新闻内容
     *
     * @param newsContent 新闻内容
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}