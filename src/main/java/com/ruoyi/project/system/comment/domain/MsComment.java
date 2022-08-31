package com.ruoyi.project.system.comment.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 评论管理对象 ms_comment
 * 
 * @author watermelonhit
 * @date 2022-08-27
 */
public class MsComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 评论时间 */
    @Excel(name = "评论时间")
    private Long createDate;

    /** 文章id */
    @Excel(name = "文章id")
    private Long articleId;

    /** 评论者id */
    @Excel(name = "评论者id")
    private Long authorId;

    /** 根评论id */
    @Excel(name = "根评论id")
    private Long parentId;

    /** 回复id */
    @Excel(name = "回复id")
    private Long toUid;

    /** 评论层级 */
    @Excel(name = "评论层级")
    private String level;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setCreateDate(Long createDate)
    {
        this.createDate = createDate;
    }

    public Long getCreateDate()
    {
        return createDate;
    }
    public void setArticleId(Long articleId)
    {
        this.articleId = articleId;
    }

    public Long getArticleId()
    {
        return articleId;
    }
    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }

    public Long getAuthorId()
    {
        return authorId;
    }
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return parentId;
    }
    public void setToUid(Long toUid)
    {
        this.toUid = toUid;
    }

    public Long getToUid()
    {
        return toUid;
    }
    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getLevel()
    {
        return level;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("content", getContent())
            .append("createDate", getCreateDate())
            .append("articleId", getArticleId())
            .append("authorId", getAuthorId())
            .append("parentId", getParentId())
            .append("toUid", getToUid())
            .append("level", getLevel())
            .toString();
    }
}
