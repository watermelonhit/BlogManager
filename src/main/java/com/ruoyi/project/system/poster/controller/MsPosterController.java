package com.ruoyi.project.system.poster.controller;

import java.util.List;
import java.util.UUID;

import com.ruoyi.common.utils.QiniuUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.poster.domain.MsPoster;
import com.ruoyi.project.system.poster.service.IMsPosterService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 轮播图管理Controller
 * 
 * @author watermelonhit
 * @date 2022-08-25
 */
@Controller
@RequestMapping("/system/poster")
public class MsPosterController extends BaseController
{
    private String prefix = "system/poster";

    @Autowired
    private IMsPosterService msPosterService;

    @RequiresPermissions("system:poster:view")
    @GetMapping()
    public String poster()
    {
        return prefix + "/poster";
    }

    /**
     * 查询轮播图管理列表
     */
    @RequiresPermissions("system:poster:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MsPoster msPoster)
    {
        startPage();
        List<MsPoster> list = msPosterService.selectMsPosterList(msPoster);
        return getDataTable(list);
    }

    /**
     * 通用上传请求（单个）
     */
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file)
    {
        //生成唯一文件名
        String fileName ="posters/"+UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(file.getOriginalFilename(), ".");

        boolean upload = QiniuUtils.upload(file, fileName);
        String url=null;
        if (upload){
            // 获取图片外链地址
            url=QiniuUtils.url + fileName;
            AjaxResult ajax = AjaxResult.success();
            System.out.println("上传成功==========》" + url);
            ajax.put("url", url);
            ajax.put("fileName", StringUtils.substringBefore(file.getOriginalFilename(), "."));
            return ajax;
        } else{
            return AjaxResult.error("图片上传失败！");
        }

    }

    /**
     * 导出轮播图管理列表
     */
    @RequiresPermissions("system:poster:export")
    @Log(title = "轮播图管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MsPoster msPoster)
    {
        List<MsPoster> list = msPosterService.selectMsPosterList(msPoster);
        ExcelUtil<MsPoster> util = new ExcelUtil<MsPoster>(MsPoster.class);
        return util.exportExcel(list, "轮播图管理数据");
    }

    /**
     * 新增轮播图管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存轮播图管理
     */
    @RequiresPermissions("system:poster:add")
    @Log(title = "轮播图管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MsPoster msPoster)
    {
        return toAjax(msPosterService.insertMsPoster(msPoster));
    }

    /**
     * 修改轮播图管理
     */
    @RequiresPermissions("system:poster:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MsPoster msPoster = msPosterService.selectMsPosterById(id);
        mmap.put("msPoster", msPoster);
        return prefix + "/edit";
    }

    /**
     * 推送轮播图到缓存
     */
    @RequiresPermissions("system:poster:push")
    @GetMapping("/push")
    @ResponseBody
    public AjaxResult push()
    {
        boolean result = msPosterService.pushPosters();
        if(result){
            return AjaxResult.success("轮播图推送成功！");
        } else {
            return AjaxResult.error("轮播图推送失败！");
        }
    }

    /**
     * 修改保存轮播图管理
     */
    @RequiresPermissions("system:poster:edit")
    @Log(title = "轮播图管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MsPoster msPoster)
    {
        return toAjax(msPosterService.updateMsPoster(msPoster));
    }

    /**
     * 删除轮播图管理
     */
    @RequiresPermissions("system:poster:remove")
    @Log(title = "轮播图管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(msPosterService.deleteMsPosterByIds(ids));
    }
}
