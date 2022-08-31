package com.ruoyi.project.system.buser.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 用户管理对象 ms_sys_user
 * 
 * @author watermelonhit
 * @date 2022-08-25
 */
public class MsSysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 是否管理员 */
    @Excel(name = "是否管理员")
    private Integer admin;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 注册时间 */
    @Excel(name = "注册时间")
    private Long createDate;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer deleted;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 最后登录时间 */
    @Excel(name = "最后登录时间")
    private Long lastLogin;

    /** 手机号 */
    @Excel(name = "手机号")
    private String mobilePhoneNumber;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 加密盐 */
    @Excel(name = "加密盐")
    private String salt;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getAccount()
    {
        return account;
    }
    public void setAdmin(Integer admin)
    {
        this.admin = admin;
    }

    public Integer getAdmin()
    {
        return admin;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setCreateDate(Long createDate)
    {
        this.createDate = createDate;
    }

    public Long getCreateDate()
    {
        return createDate;
    }
    public void setDeleted(Integer deleted)
    {
        this.deleted = deleted;
    }

    public Integer getDeleted()
    {
        return deleted;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setLastLogin(Long lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    public Long getLastLogin()
    {
        return lastLogin;
    }
    public void setMobilePhoneNumber(String mobilePhoneNumber)
    {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getMobilePhoneNumber()
    {
        return mobilePhoneNumber;
    }
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getNickname()
    {
        return nickname;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getSalt()
    {
        return salt;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("account", getAccount())
            .append("admin", getAdmin())
            .append("avatar", getAvatar())
            .append("createDate", getCreateDate())
            .append("deleted", getDeleted())
            .append("email", getEmail())
            .append("lastLogin", getLastLogin())
            .append("mobilePhoneNumber", getMobilePhoneNumber())
            .append("nickname", getNickname())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("status", getStatus())
            .toString();
    }
}
