package com.ruoyi.project.system.poster.service.impl;

import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.poster.domain.PosterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.poster.mapper.MsPosterMapper;
import com.ruoyi.project.system.poster.domain.MsPoster;
import com.ruoyi.project.system.poster.service.IMsPosterService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 轮播图管理Service业务层处理
 * 
 * @author watermelonhit
 * @date 2022-08-25
 */
@Service
public class MsPosterServiceImpl implements IMsPosterService 
{
    @Autowired
    private MsPosterMapper msPosterMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 查询轮播图管理
     * 
     * @param id 轮播图管理主键
     * @return 轮播图管理
     */
    @Override
    public MsPoster selectMsPosterById(Long id)
    {
        return msPosterMapper.selectMsPosterById(id);
    }

    /**
     * 查询轮播图管理列表
     * 
     * @param msPoster 轮播图管理
     * @return 轮播图管理
     */
    @Override
    public List<MsPoster> selectMsPosterList(MsPoster msPoster)
    {
        return msPosterMapper.selectMsPosterList(msPoster);
    }

    /**
     * 新增轮播图管理
     * 
     * @param msPoster 轮播图管理
     * @return 结果
     */
    @Override
    public int insertMsPoster(MsPoster msPoster)
    {
        msPoster.setCreateTime(DateUtils.getNowDate());
        return msPosterMapper.insertMsPoster(msPoster);
    }

    /**
     * 修改轮播图管理
     * 
     * @param msPoster 轮播图管理
     * @return 结果
     */
    @Override
    public int updateMsPoster(MsPoster msPoster)
    {
        return msPosterMapper.updateMsPoster(msPoster);
    }

    /**
     * 批量删除轮播图管理
     * 
     * @param ids 需要删除的轮播图管理主键
     * @return 结果
     */
    @Override
    public int deleteMsPosterByIds(String ids)
    {
        return msPosterMapper.deleteMsPosterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除轮播图管理信息
     * 
     * @param id 轮播图管理主键
     * @return 结果
     */
    @Override
    public int deleteMsPosterById(Long id)
    {
        return msPosterMapper.deleteMsPosterById(id);
    }

    @Override
    public boolean pushPosters() {
        List<PosterVo> urls=msPosterMapper.pushPosters();
        if(urls==null||urls.size()<=0){
            return false;
        }
        Gson gson = new Gson();
        String jsonUrls=gson.toJson(urls);
        // 删除原有的
        stringRedisTemplate.delete("BLOG_POSTERS");
        stringRedisTemplate.opsForValue().set("BLOG_POSTERS", jsonUrls);
        return true;
    }
}
