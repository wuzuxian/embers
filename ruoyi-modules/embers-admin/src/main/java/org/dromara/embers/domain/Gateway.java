package org.dromara.embers.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 长链接接入网关对象 t_gateway
 *
 * @author Lion Li
 * @date 2023-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_gateway")
public class Gateway extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(value = "id")
    private Long id;

    /**
     * gateway网关地址
     */
    private String url;

    /**
     * 订阅消息主题
     */
    private String topic;

    /**
     * 支持协议：0=全部支持，1=tcp，2=udp，3=websocket
     */
    private Long protocol;

    /**
     * 注册密钥
     */
    private String secretKey;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 最大连接总数
     */
    private Long maxConnectionNumber;

    /**
     * 剩余连接数
     */
    private Long remainingConnectionNumber;


}
