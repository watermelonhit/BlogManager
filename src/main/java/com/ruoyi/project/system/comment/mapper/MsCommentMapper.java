package com.ruoyi.project.system.comment.mapper;

import java.util.List;
import com.ruoyi.project.system.comment.domain.MsComment;

/**
 * 评论管理Mapper接口
 * 
 * @author watermelonhit
 * @date 2022-08-27
 */
public interface MsCommentMapper 
{
    /**
     * 查询评论管理
     * 
     * @param id 评论管理主键
     * @return 评论管理
     */
    public MsComment selectMsCommentById(Long id);

    /**
     * 查询评论管理列表
     * 
     * @param msComment 评论管理
     * @return 评论管理集合
     */
    public List<MsComment> selectMsCommentList(MsComment msComment);

    /**
     * 新增评论管理
     * 
     * @param msComment 评论管理
     * @return 结果
     */
    public int insertMsComment(MsComment msComment);

    /**
     * 修改评论管理
     * 
     * @param msComment 评论管理
     * @return 结果
     */
    public int updateMsComment(MsComment msComment);

    /**
     * 删除评论管理
     * 
     * @param id 评论管理主键
     * @return 结果
     */
    public int deleteMsCommentById(Long id);

    /**
     * 批量删除评论管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMsCommentByIds(String[] ids);

    void deleteRelatedCommentsById(String id);
}
