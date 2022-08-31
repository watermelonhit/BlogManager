package com.ruoyi.project.system.board.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 留言管理对象 ms_board
 * 
 * @author watermelonhit
 * @date 2022-08-27
 */
public class MsBoard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 评论者id */
    @Excel(name = "评论者id")
    private Long authorId;

    /** 内容 */
    @Excel(name = "内容")
    private String context;

    /** 留言状态 */
    @Excel(name = "留言状态")
    private Integer statue;

    /** ip地址 */
    @Excel(name = "ip地址")
    private String ip;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }

    public Long getAuthorId()
    {
        return authorId;
    }
    public void setContext(String context)
    {
        this.context = context;
    }

    public String getContext()
    {
        return context;
    }
    public void setStatue(Integer statue)
    {
        this.statue = statue;
    }

    public Integer getStatue()
    {
        return statue;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("authorId", getAuthorId())
            .append("context", getContext())
            .append("statue", getStatue())
            .append("createTime", getCreateTime())
            .append("ip", getIp())
            .toString();
    }
}
