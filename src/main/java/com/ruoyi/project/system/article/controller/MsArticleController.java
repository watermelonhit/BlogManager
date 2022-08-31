package com.ruoyi.project.system.article.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.article.domain.MsArticle;
import com.ruoyi.project.system.article.service.IMsArticleService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 文章管理Controller
 * 
 * @author watermelonhit
 * @date 2022-08-28
 */
@Controller
@RequestMapping("/system/article")
public class MsArticleController extends BaseController
{
    private String prefix = "system/article";

    @Autowired
    private IMsArticleService msArticleService;

    @RequiresPermissions("system:article:view")
    @GetMapping()
    public String article()
    {
        return prefix + "/article";
    }

    /**
     * 查询文章管理列表
     */
    @RequiresPermissions("system:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MsArticle msArticle)
    {
        startPage();
        List<MsArticle> list = msArticleService.selectMsArticleList(msArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章管理列表
     */
    @RequiresPermissions("system:article:export")
    @Log(title = "文章管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MsArticle msArticle)
    {
        List<MsArticle> list = msArticleService.selectMsArticleList(msArticle);
        ExcelUtil<MsArticle> util = new ExcelUtil<MsArticle>(MsArticle.class);
        return util.exportExcel(list, "文章管理数据");
    }

    /**
     * 新增文章管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章管理
     */
    @RequiresPermissions("system:article:add")
    @Log(title = "文章管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MsArticle msArticle)
    {
        return toAjax(msArticleService.insertMsArticle(msArticle));
    }

    /**
     * 修改文章管理
     */
    @RequiresPermissions("system:article:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MsArticle msArticle = msArticleService.selectMsArticleById(id);
        mmap.put("msArticle", msArticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章管理
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "文章管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MsArticle msArticle)
    {
        return toAjax(msArticleService.updateMsArticle(msArticle));
    }

    /**
     * 删除文章管理
     */
    @RequiresPermissions("system:article:remove")
    @Log(title = "文章管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(msArticleService.deleteMsArticleByIds(ids));
    }
}
