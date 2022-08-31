package com.ruoyi.project.system.poster.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 轮播图管理对象 ms_poster
 * 
 * @author watermelonhit
 * @date 2022-08-25
 */
public class MsPoster extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片id */
    @Excel(name = "图片id")
    private Long id;

    /** 图片名称 */
    @Excel(name = "图片名称")
    private String name;

    /** 图片存储链接 */
    @Excel(name = "图片存储链接")
    private String fromUrl;

    /** 跳转链接 */
    @Excel(name = "跳转链接")
    private String toUrl;

    /** 图片的相关信息 */
    @Excel(name = "图片的相关信息")
    private String information;

    /** 状态 */
    @Excel(name = "状态")
    private Integer state;

    /** 点击次数 */
    @Excel(name = "点击次数")
    private Long count;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setFromUrl(String fromUrl)
    {
        this.fromUrl = fromUrl;
    }

    public String getFromUrl()
    {
        return fromUrl;
    }
    public void setToUrl(String toUrl)
    {
        this.toUrl = toUrl;
    }

    public String getToUrl()
    {
        return toUrl;
    }
    public void setInformation(String information)
    {
        this.information = information;
    }

    public String getInformation()
    {
        return information;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getState()
    {
        return state;
    }
    public void setCount(Long count)
    {
        this.count = count;
    }

    public Long getCount()
    {
        return count;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("fromUrl", getFromUrl())
            .append("toUrl", getToUrl())
            .append("information", getInformation())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("count", getCount())
            .toString();
    }
}
