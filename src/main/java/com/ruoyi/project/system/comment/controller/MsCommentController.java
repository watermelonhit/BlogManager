package com.ruoyi.project.system.comment.controller;

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
import com.ruoyi.project.system.comment.domain.MsComment;
import com.ruoyi.project.system.comment.service.IMsCommentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 评论管理Controller
 * 
 * @author watermelonhit
 * @date 2022-08-27
 */
@Controller
@RequestMapping("/system/comment")
public class MsCommentController extends BaseController
{
    private String prefix = "system/comment";

    @Autowired
    private IMsCommentService msCommentService;

    @RequiresPermissions("system:comment:view")
    @GetMapping()
    public String comment()
    {
        return prefix + "/comment";
    }

    /**
     * 查询评论管理列表
     */
    @RequiresPermissions("system:comment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MsComment msComment)
    {
        startPage();
        List<MsComment> list = msCommentService.selectMsCommentList(msComment);
        return getDataTable(list);
    }

    /**
     * 导出评论管理列表
     */
    @RequiresPermissions("system:comment:export")
    @Log(title = "评论管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MsComment msComment)
    {
        List<MsComment> list = msCommentService.selectMsCommentList(msComment);
        ExcelUtil<MsComment> util = new ExcelUtil<MsComment>(MsComment.class);
        return util.exportExcel(list, "评论管理数据");
    }

    /**
     * 新增评论管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评论管理
     */
    @RequiresPermissions("system:comment:add")
    @Log(title = "评论管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MsComment msComment)
    {
        return toAjax(msCommentService.insertMsComment(msComment));
    }

    /**
     * 修改评论管理
     */
    @RequiresPermissions("system:comment:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MsComment msComment = msCommentService.selectMsCommentById(id);
        mmap.put("msComment", msComment);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论管理
     */
    @RequiresPermissions("system:comment:edit")
    @Log(title = "评论管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MsComment msComment)
    {
        return toAjax(msCommentService.updateMsComment(msComment));
    }

    /**
     * 删除评论管理,若根评论被删除的话，其关联评论也会被删除。
     */
    @RequiresPermissions("system:comment:remove")
    @Log(title = "评论管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        System.out.println("delete comment"+"=====>"+ids);
        return toAjax(msCommentService.deleteMsCommentByIds(ids));
    }
}
