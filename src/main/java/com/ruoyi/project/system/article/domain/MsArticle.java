package com.ruoyi.project.system.article.domain;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 文章管理对象 ms_article
 * 
 * @author watermelonhit
 * @date 2022-08-28
 */
public class MsArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 评论数量 */
    @Excel(name = "评论数量")
    private Long commentCounts;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Long createDate;

    /** 简介 */
    @Excel(name = "简介")
    private String summary;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 浏览数量 */
    @Excel(name = "浏览数量")
    private Long viewCounts;

    /** 是否置顶 */
    @Excel(name = "是否置顶")
    private Long weight;

    /** 作者id */
    @Excel(name = "作者id")
    private Long authorId;

    /** 内容id */
    @Excel(name = "内容id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long bodyId;

    /** 类别id */
    @Excel(name = "类别id")
    private Long categoryId;

    /** $table.subTable.functionName信息 */
    private List<MsArticleBody> msArticleBodyList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCommentCounts(Long commentCounts)
    {
        this.commentCounts = commentCounts;
    }

    public Long getCommentCounts()
    {
        return commentCounts;
    }
    public void setCreateDate(Long createDate)
    {
        this.createDate = createDate;
    }

    public Long getCreateDate()
    {
        return createDate;
    }
    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setViewCounts(Long viewCounts)
    {
        this.viewCounts = viewCounts;
    }

    public Long getViewCounts()
    {
        return viewCounts;
    }
    public void setWeight(Long weight)
    {
        this.weight = weight;
    }

    public Long getWeight()
    {
        return weight;
    }
    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }

    public Long getAuthorId()
    {
        return authorId;
    }
    public void setBodyId(Long bodyId)
    {
        this.bodyId = bodyId;
    }

    public Long getBodyId()
    {
        return bodyId;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }

    public List<MsArticleBody> getMsArticleBodyList()
    {
        return msArticleBodyList;
    }

    public void setMsArticleBodyList(List<MsArticleBody> msArticleBodyList)
    {
        this.msArticleBodyList = msArticleBodyList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("commentCounts", getCommentCounts())
            .append("createDate", getCreateDate())
            .append("summary", getSummary())
            .append("title", getTitle())
            .append("viewCounts", getViewCounts())
            .append("weight", getWeight())
            .append("authorId", getAuthorId())
            .append("bodyId", getBodyId())
            .append("categoryId", getCategoryId())
            .append("msArticleBodyList", getMsArticleBodyList())
            .toString();
    }
}
