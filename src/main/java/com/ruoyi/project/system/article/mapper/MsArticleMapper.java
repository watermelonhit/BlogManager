package com.ruoyi.project.system.article.mapper;

import java.util.List;
import com.ruoyi.project.system.article.domain.MsArticle;
import com.ruoyi.project.system.article.domain.MsArticleBody;

/**
 * 文章管理Mapper接口
 * 
 * @author watermelonhit
 * @date 2022-08-28
 */
public interface MsArticleMapper 
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
     * 删除文章管理
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    public int deleteMsArticleById(Long id);

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMsArticleByIds(String[] ids);

    /**
     * 批量删除${subTable.functionName}
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMsArticleBodyByArticleIds(String[] ids);
    
    /**
     * 批量新增${subTable.functionName}
     * 
     * @param msArticleBodyList ${subTable.functionName}列表
     * @return 结果
     */
    public int batchMsArticleBody(List<MsArticleBody> msArticleBodyList);
    

    /**
     * 通过文章管理主键删除${subTable.functionName}信息
     * 
     * @param id 文章管理ID
     * @return 结果
     */
    public int deleteMsArticleBodyByArticleId(Long id);
}
