package org.dromara.embers.service;

import org.dromara.embers.domain.vo.GatewayVo;
import org.dromara.embers.domain.bo.GatewayBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 长链接接入网关Service接口
 *
 * @author Lion Li
 * @date 2023-11-30
 */
public interface IGatewayService {

    /**
     * 查询长链接接入网关
     */
    GatewayVo queryById(Long id);

    /**
     * 查询长链接接入网关列表
     */
    TableDataInfo<GatewayVo> queryPageList(GatewayBo bo, PageQuery pageQuery);

    /**
     * 查询长链接接入网关列表
     */
    List<GatewayVo> queryList(GatewayBo bo);

    /**
     * 新增长链接接入网关
     */
    Boolean insertByBo(GatewayBo bo);

    /**
     * 修改长链接接入网关
     */
    Boolean updateByBo(GatewayBo bo);

    /**
     * 校验并批量删除长链接接入网关信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
