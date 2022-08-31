package com.ruoyi.project.system.article.service;

import java.util.List;
import com.ruoyi.project.system.article.domain.MsArticle;

/**
 * 文章管理Service接口
 * 
 * @author watermelonhit
 * @date 2022-08-28
 */
public interface IMsArticleService 
{
    /**
     * 查询文章管理
     * 
     * @param id 文章管理主键
     * @return 文章管理
     */
    public MsArticle selectMsArticleById(Long id);

    /**
     * 查询文章管理列表
     * 
     * @param msArticle 文章管理
     * @return 文章管理集合
     */
    public List<MsArticle> selectMsArticleList(MsArticle msArticle);

    /**
     * 新增文章管理
     * 
     * @param msArticle 文章管理
     * @return 结果
     */
    public int insertMsArticle(MsArticle msArticle);

    /**
     * 修改文章管理
     * 
     * @param msArticle 文章管理
     * @return 结果
     */
    public int updateMsArticle(MsArticle msArticle);

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的文章管理主键集合
     * @return 结果
     */
    public int deleteMsArticleByIds(String ids);

    /**
     * 删除文章管理信息
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    public int deleteMsArticleById(Long id);
}
