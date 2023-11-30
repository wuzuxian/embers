package org.dromara.embers.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.dromara.embers.domain.Gateway;
import org.dromara.embers.domain.bo.GatewayBo;
import org.dromara.embers.domain.vo.GatewayVo;
import org.dromara.embers.mapper.GatewayMapper;
import org.dromara.embers.service.IGatewayService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 长链接接入网关Service业务层处理
 *
 * @author Lion Li
 * @date 2023-11-30
 */
@RequiredArgsConstructor
@Service
public class GatewayServiceImpl implements IGatewayService {

    private final GatewayMapper baseMapper;

    /**
     * 查询长链接接入网关
     */
    @Override
    public GatewayVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询长链接接入网关列表
     */
    @Override
    public TableDataInfo<GatewayVo> queryPageList(GatewayBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Gateway> lqw = buildQueryWrapper(bo);
        Page<GatewayVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询长链接接入网关列表
     */
    @Override
    public List<GatewayVo> queryList(GatewayBo bo) {
        LambdaQueryWrapper<Gateway> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Gateway> buildQueryWrapper(GatewayBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Gateway> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getUrl()), Gateway::getUrl, bo.getUrl());
        lqw.eq(StringUtils.isNotBlank(bo.getTopic()), Gateway::getTopic, bo.getTopic());
        lqw.eq(bo.getProtocol() != null, Gateway::getProtocol, bo.getProtocol());
        lqw.eq(StringUtils.isNotBlank(bo.getSecretKey()), Gateway::getSecretKey, bo.getSecretKey());
        lqw.eq(bo.getRegisterTime() != null, Gateway::getRegisterTime, bo.getRegisterTime());
        lqw.eq(bo.getMaxConnectionNumber() != null, Gateway::getMaxConnectionNumber, bo.getMaxConnectionNumber());
        lqw.eq(bo.getRemainingConnectionNumber() != null, Gateway::getRemainingConnectionNumber, bo.getRemainingConnectionNumber());
        return lqw;
    }

    /**
     * 新增长链接接入网关
     */
    @Override
    public Boolean insertByBo(GatewayBo bo) {
        Gateway add = MapstructUtils.convert(bo, Gateway.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改长链接接入网关
     */
    @Override
    public Boolean updateByBo(GatewayBo bo) {
        Gateway update = MapstructUtils.convert(bo, Gateway.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Gateway entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除长链接接入网关
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
