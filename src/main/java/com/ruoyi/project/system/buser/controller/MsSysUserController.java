package com.ruoyi.project.system.buser.controller;

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
import com.ruoyi.project.system.buser.domain.MsSysUser;
import com.ruoyi.project.system.buser.service.IMsSysUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户管理Controller
 * 
 * @author watermelonhit
 * @date 2022-08-25
 */
@Controller
@RequestMapping("/system/buser")
public class MsSysUserController extends BaseController
{
    private String prefix = "system/buser";

    @Autowired
    private IMsSysUserService msSysUserService;

    @RequiresPermissions("system:buser:view")
    @GetMapping()
    public String buser()
    {
        return prefix + "/buser";
    }

    /**
     * 查询用户管理列表
     */
    @RequiresPermissions("system:buser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MsSysUser msSysUser)
    {
        startPage();
        List<MsSysUser> list = msSysUserService.selectMsSysUserList(msSysUser);
        return getDataTable(list);
    }

    /**
     * 导出用户管理列表
     */
    @RequiresPermissions("system:buser:export")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MsSysUser msSysUser)
    {
        List<MsSysUser> list = msSysUserService.selectMsSysUserList(msSysUser);
        ExcelUtil<MsSysUser> util = new ExcelUtil<MsSysUser>(MsSysUser.class);
        return util.exportExcel(list, "用户管理数据");
    }

    /**
     * 新增用户管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户管理
     */
    @RequiresPermissions("system:buser:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MsSysUser msSysUser)
    {
        return toAjax(msSysUserService.insertMsSysUser(msSysUser));
    }

    /**
     * 修改用户管理
     */
    @RequiresPermissions("system:buser:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MsSysUser msSysUser = msSysUserService.selectMsSysUserById(id);
        mmap.put("msSysUser", msSysUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户管理
     */
    @RequiresPermissions("system:buser:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MsSysUser msSysUser)
    {
        return toAjax(msSysUserService.updateMsSysUser(msSysUser));
    }

    /**
     * 删除用户管理
     */
    @RequiresPermissions("system:buser:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(msSysUserService.deleteMsSysUserByIds(ids));
    }
}
