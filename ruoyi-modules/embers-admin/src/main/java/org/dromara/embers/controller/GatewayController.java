package org.dromara.embers.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.dromara.embers.service.IGatewayService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.embers.domain.vo.GatewayVo;
import org.dromara.embers.domain.bo.GatewayBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 长链接接入网关
 *
 * @author Lion Li
 * @date 2023-11-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/embers-admin/gateway")
public class GatewayController extends BaseController {

    private final IGatewayService gatewayService;

    /**
     * 查询长链接接入网关列表
     */
    @SaCheckPermission("embers-admin:gateway:list")
    @GetMapping("/list")
    public TableDataInfo<GatewayVo> list(GatewayBo bo, PageQuery pageQuery) {
        return gatewayService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出长链接接入网关列表
     */
    @SaCheckPermission("embers-admin:gateway:export")
    @Log(title = "长链接接入网关", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(GatewayBo bo, HttpServletResponse response) {
        List<GatewayVo> list = gatewayService.queryList(bo);
        ExcelUtil.exportExcel(list, "长链接接入网关", GatewayVo.class, response);
    }

    /**
     * 获取长链接接入网关详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("embers-admin:gateway:query")
    @GetMapping("/{id}")
    public R<GatewayVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(gatewayService.queryById(id));
    }

    /**
     * 新增长链接接入网关
     */
    @SaCheckPermission("embers-admin:gateway:add")
    @Log(title = "长链接接入网关", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody GatewayBo bo) {
        return toAjax(gatewayService.insertByBo(bo));
    }

    /**
     * 修改长链接接入网关
     */
    @SaCheckPermission("embers-admin:gateway:edit")
    @Log(title = "长链接接入网关", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody GatewayBo bo) {
        return toAjax(gatewayService.updateByBo(bo));
    }

    /**
     * 删除长链接接入网关
     *
     * @param ids 主键串
     */
    @SaCheckPermission("embers-admin:gateway:remove")
    @Log(title = "长链接接入网关", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(gatewayService.deleteWithValidByIds(List.of(ids), true));
    }
}
