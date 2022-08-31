package com.ruoyi.project.system.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.comment.mapper.MsCommentMapper;
import com.ruoyi.project.system.comment.domain.MsComment;
import com.ruoyi.project.system.comment.service.IMsCommentService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 评论管理Service业务层处理
 *
 * @author watermelonhit
 * @date 2022-08-27
 */
@Service
public class MsCommentServiceImpl implements IMsCommentService {
    @Autowired
    private MsCommentMapper msCommentMapper;

    /**
     * 查询评论管理
     *
     * @param id 评论管理主键
     * @return 评论管理
     */
    @Override
    public MsComment selectMsCommentById(Long id) {
        return msCommentMapper.selectMsCommentById(id);
    }

    /**
     * 查询评论管理列表
     *
     * @param msComment 评论管理
     * @return 评论管理
     */
    @Override
    public List<MsComment> selectMsCommentList(MsComment msComment) {
        return msCommentMapper.selectMsCommentList(msComment);
    }

    /**
     * 新增评论管理
     *
     * @param msComment 评论管理
     * @return 结果
     */
    @Override
    public int insertMsComment(MsComment msComment) {
        return msCommentMapper.insertMsComment(msComment);
    }

    /**
     * 修改评论管理
     *
     * @param msComment 评论管理
     * @return 结果
     */
    @Override
    public int updateMsComment(MsComment msComment) {
        return msCommentMapper.updateMsComment(msComment);
    }

    /**
     * 批量删除评论管理
     *
     * @param ids 需要删除的评论管理主键
     * @return 结果
     */
    @Override
    public int deleteMsCommentByIds(String ids) {
        // 删除相关联的子评论
        String[] idArray = ids.split(",");
        if (idArray != null && idArray.length > 0) {
            for (String id : idArray) {
                msCommentMapper.deleteRelatedCommentsById(id);
            }
        }
        return msCommentMapper.deleteMsCommentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论管理信息
     *
     * @param id 评论管理主键
     * @return 结果
     */
    @Override
    public int deleteMsCommentById(Long id) {
        return msCommentMapper.deleteMsCommentById(id);
    }
}
