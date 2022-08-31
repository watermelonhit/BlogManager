package com.ruoyi.project.system.buser.service;

import java.util.List;
import com.ruoyi.project.system.buser.domain.MsSysUser;

/**
 * 用户管理Service接口
 * 
 * @author watermelonhit
 * @date 2022-08-25
 */
public interface IMsSysUserService 
{
    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    public MsSysUser selectMsSysUserById(Long id);

    /**
     * 查询用户管理列表
     * 
     * @param msSysUser 用户管理
     * @return 用户管理集合
     */
    public List<MsSysUser> selectMsSysUserList(MsSysUser msSysUser);

    /**
     * 新增用户管理
     * 
     * @param msSysUser 用户管理
     * @return 结果
     */
    public int insertMsSysUser(MsSysUser msSysUser);

    /**
     * 修改用户管理
     * 
     * @param msSysUser 用户管理
     * @return 结果
     */
    public int updateMsSysUser(MsSysUser msSysUser);

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的用户管理主键集合
     * @return 结果
     */
    public int deleteMsSysUserByIds(String ids);

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    public int deleteMsSysUserById(Long id);
}
