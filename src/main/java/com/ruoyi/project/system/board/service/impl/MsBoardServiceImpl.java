package com.ruoyi.project.system.board.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.board.mapper.MsBoardMapper;
import com.ruoyi.project.system.board.domain.MsBoard;
import com.ruoyi.project.system.board.service.IMsBoardService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 留言管理Service业务层处理
 * 
 * @author watermelonhit
 * @date 2022-08-27
 */
@Service
public class MsBoardServiceImpl implements IMsBoardService 
{
    @Autowired
    private MsBoardMapper msBoardMapper;

    /**
     * 查询留言管理
     * 
     * @param id 留言管理主键
     * @return 留言管理
     */
    @Override
    public MsBoard selectMsBoardById(Long id)
    {
        return msBoardMapper.selectMsBoardById(id);
    }

    /**
     * 查询留言管理列表
     * 
     * @param msBoard 留言管理
     * @return 留言管理
     */
    @Override
    public List<MsBoard> selectMsBoardList(MsBoard msBoard)
    {
        return msBoardMapper.selectMsBoardList(msBoard);
    }

    /**
     * 新增留言管理
     * 
     * @param msBoard 留言管理
     * @return 结果
     */
    @Override
    public int insertMsBoard(MsBoard msBoard)
    {
        msBoard.setCreateTime(DateUtils.getNowDate());
        return msBoardMapper.insertMsBoard(msBoard);
    }

    /**
     * 修改留言管理
     * 
     * @param msBoard 留言管理
     * @return 结果
     */
    @Override
    public int updateMsBoard(MsBoard msBoard)
    {
        return msBoardMapper.updateMsBoard(msBoard);
    }

    /**
     * 批量删除留言管理
     * 
     * @param ids 需要删除的留言管理主键
     * @return 结果
     */
    @Override
    public int deleteMsBoardByIds(String ids)
    {
        return msBoardMapper.deleteMsBoardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除留言管理信息
     * 
     * @param id 留言管理主键
     * @return 结果
     */
    @Override
    public int deleteMsBoardById(Long id)
    {
        return msBoardMapper.deleteMsBoardById(id);
    }
}
