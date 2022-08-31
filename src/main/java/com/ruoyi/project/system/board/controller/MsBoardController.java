package com.ruoyi.project.system.board.controller;

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
import com.ruoyi.project.system.board.domain.MsBoard;
import com.ruoyi.project.system.board.service.IMsBoardService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 留言管理Controller
 * 
 * @author watermelonhit
 * @date 2022-08-27
 */
@Controller
@RequestMapping("/system/board")
public class MsBoardController extends BaseController
{
    private String prefix = "system/board";

    @Autowired
    private IMsBoardService msBoardService;

    @RequiresPermissions("system:board:view")
    @GetMapping()
    public String board()
    {
        return prefix + "/board";
    }

    /**
     * 查询留言管理列表
     */
    @RequiresPermissions("system:board:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MsBoard msBoard)
    {
        startPage();
        List<MsBoard> list = msBoardService.selectMsBoardList(msBoard);
        return getDataTable(list);
    }

    /**
     * 导出留言管理列表
     */
    @RequiresPermissions("system:board:export")
    @Log(title = "留言管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MsBoard msBoard)
    {
        List<MsBoard> list = msBoardService.selectMsBoardList(msBoard);
        ExcelUtil<MsBoard> util = new ExcelUtil<MsBoard>(MsBoard.class);
        return util.exportExcel(list, "留言管理数据");
    }

    /**
     * 新增留言管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存留言管理
     */
    @RequiresPermissions("system:board:add")
    @Log(title = "留言管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MsBoard msBoard)
    {
        return toAjax(msBoardService.insertMsBoard(msBoard));
    }

    /**
     * 修改留言管理
     */
    @RequiresPermissions("system:board:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MsBoard msBoard = msBoardService.selectMsBoardById(id);
        mmap.put("msBoard", msBoard);
        return prefix + "/edit";
    }

    /**
     * 修改保存留言管理
     */
    @RequiresPermissions("system:board:edit")
    @Log(title = "留言管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MsBoard msBoard)
    {
        return toAjax(msBoardService.updateMsBoard(msBoard));
    }

    /**
     * 删除留言管理
     */
    @RequiresPermissions("system:board:remove")
    @Log(title = "留言管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(msBoardService.deleteMsBoardByIds(ids));
    }
}
