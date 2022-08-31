package com.ruoyi.project.system.poster.service;

import java.util.List;
import com.ruoyi.project.system.poster.domain.MsPoster;

/**
 * 轮播图管理Service接口
 * 
 * @author watermelonhit
 * @date 2022-08-25
 */
public interface IMsPosterService 
{
    /**
     * 查询轮播图管理
     * 
     * @param id 轮播图管理主键
     * @return 轮播图管理
     */
    public MsPoster selectMsPosterById(Long id);

    /**
     * 查询轮播图管理列表
     * 
     * @param msPoster 轮播图管理
     * @return 轮播图管理集合
     */
    public List<MsPoster> selectMsPosterList(MsPoster msPoster);

    /**
     * 新增轮播图管理
     * 
     * @param msPoster 轮播图管理
     * @return 结果
     */
    public int insertMsPoster(MsPoster msPoster);

    /**
     * 修改轮播图管理
     * 
     * @param msPoster 轮播图管理
     * @return 结果
     */
    public int updateMsPoster(MsPoster msPoster);

    /**
     * 批量删除轮播图管理
     * 
     * @param ids 需要删除的轮播图管理主键集合
     * @return 结果
     */
    public int deleteMsPosterByIds(String ids);

    /**
     * 删除轮播图管理信息
     * 
     * @param id 轮播图管理主键
     * @return 结果
     */
    public int deleteMsPosterById(Long id);

    boolean pushPosters();
}
