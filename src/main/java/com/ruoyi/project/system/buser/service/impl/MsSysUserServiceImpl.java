package com.ruoyi.project.system.buser.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.buser.mapper.MsSysUserMapper;
import com.ruoyi.project.system.buser.domain.MsSysUser;
import com.ruoyi.project.system.buser.service.IMsSysUserService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 用户管理Service业务层处理
 * 
 * @author watermelonhit
 * @date 2022-08-25
 */
@Service
public class MsSysUserServiceImpl implements IMsSysUserService 
{
    @Autowired
    private MsSysUserMapper msSysUserMapper;

    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    @Override
    public MsSysUser selectMsSysUserById(Long id)
    {
        return msSysUserMapper.selectMsSysUserById(id);
    }

    /**
     * 查询用户管理列表
     * 
     * @param msSysUser 用户管理
     * @return 用户管理
     */
    @Override
    public List<MsSysUser> selectMsSysUserList(MsSysUser msSysUser)
    {
        return msSysUserMapper.selectMsSysUserList(msSysUser);
    }

    /**
     * 新增用户管理
     * 
     * @param msSysUser 用户管理
     * @return 结果
     */
    @Override
    public int insertMsSysUser(MsSysUser msSysUser)
    {
        return msSysUserMapper.insertMsSysUser(msSysUser);
    }

    /**
     * 修改用户管理
     * 
     * @param msSysUser 用户管理
     * @return 结果
     */
    @Override
    public int updateMsSysUser(MsSysUser msSysUser)
    {
        return msSysUserMapper.updateMsSysUser(msSysUser);
    }

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的用户管理主键
     * @return 结果
     */
    @Override
    public int deleteMsSysUserByIds(String ids)
    {
        return msSysUserMapper.deleteMsSysUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    @Override
    public int deleteMsSysUserById(Long id)
    {
        return msSysUserMapper.deleteMsSysUserById(id);
    }
}
