package com.ruoyi.project.system.article.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.system.article.domain.MsArticleBody;
import com.ruoyi.project.system.article.mapper.MsArticleMapper;
import com.ruoyi.project.system.article.domain.MsArticle;
import com.ruoyi.project.system.article.service.IMsArticleService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 文章管理Service业务层处理
 * 
 * @author watermelonhit
 * @date 2022-08-28
 */
@Service
public class MsArticleServiceImpl implements IMsArticleService 
{
    @Autowired
    private MsArticleMapper msArticleMapper;

    /**
     * 查询文章管理
     * 
     * @param id 文章管理主键
     * @return 文章管理
     */
    @Override
    public MsArticle selectMsArticleById(Long id)
    {
        return msArticleMapper.selectMsArticleById(id);
    }

    /**
     * 查询文章管理列表
     * 
     * @param msArticle 文章管理
     * @return 文章管理
     */
    @Override
    public List<MsArticle> selectMsArticleList(MsArticle msArticle)
    {
        return msArticleMapper.selectMsArticleList(msArticle);
    }

    /**
     * 新增文章管理
     * 
     * @param msArticle 文章管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertMsArticle(MsArticle msArticle)
    {
        int rows = msArticleMapper.insertMsArticle(msArticle);
        insertMsArticleBody(msArticle);
        return rows;
    }

    /**
     * 修改文章管理
     * 
     * @param msArticle 文章管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMsArticle(MsArticle msArticle)
    {
        msArticleMapper.deleteMsArticleBodyByArticleId(msArticle.getId());
        insertMsArticleBody(msArticle);

        return msArticleMapper.updateMsArticle(msArticle);
    }

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的文章管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMsArticleByIds(String ids)
    {
        msArticleMapper.deleteMsArticleBodyByArticleIds(Convert.toStrArray(ids));
        return msArticleMapper.deleteMsArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章管理信息
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteMsArticleById(Long id)
    {
        msArticleMapper.deleteMsArticleBodyByArticleId(id);
        return msArticleMapper.deleteMsArticleById(id);
    }

    /**
     * 新增${subTable.functionName}信息
     * 
     * @param msArticle 文章管理对象
     */
    public void insertMsArticleBody(MsArticle msArticle)
    {
        List<MsArticleBody> msArticleBodyList = msArticle.getMsArticleBodyList();
        Long id = msArticle.getId();
        if (StringUtils.isNotNull(msArticleBodyList))
        {
            List<MsArticleBody> list = new ArrayList<MsArticleBody>();
            for (MsArticleBody msArticleBody : msArticleBodyList)
            {
                msArticleBody.setArticleId(id);
                list.add(msArticleBody);
            }
            if (list.size() > 0)
            {
                msArticleMapper.batchMsArticleBody(list);
                System.out.println("id==========>"+list.get(0).getId());
                // 注入id
                msArticle.setBodyId(list.get(0).getId());
            }
        }
    }
}
