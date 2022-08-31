package com.ruoyi.project.system.board.service;

import java.util.List;
import com.ruoyi.project.system.board.domain.MsBoard;

/**
 * 留言管理Service接口
 * 
 * @author watermelonhit
 * @date 2022-08-27
 */
public interface IMsBoardService 
{
    /**
     * 查询留言管理
     * 
     * @param id 留言管理主键
     * @return 留言管理
     */
    public MsBoard selectMsBoardById(Long id);

    /**
     * 查询留言管理列表
     * 
     * @param msBoard 留言管理
     * @return 留言管理集合
     */
    public List<MsBoard> selectMsBoardList(MsBoard msBoard);

    /**
     * 新增留言管理
     * 
     * @param msBoard 留言管理
     * @return 结果
     */
    public int insertMsBoard(MsBoard msBoard);

    /**
     * 修改留言管理
     * 
     * @param msBoard 留言管理
     * @return 结果
     */
    public int updateMsBoard(MsBoard msBoard);

    /**
     * 批量删除留言管理
     * 
     * @param ids 需要删除的留言管理主键集合
     * @return 结果
     */
    public int deleteMsBoardByIds(String ids);

    /**
     * 删除留言管理信息
     * 
     * @param id 留言管理主键
     * @return 结果
     */
    public int deleteMsBoardById(Long id);
}
