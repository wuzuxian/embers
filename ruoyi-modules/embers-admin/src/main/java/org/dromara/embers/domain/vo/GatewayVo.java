package org.dromara.embers.domain.vo;

import java.util.Date;

import org.dromara.embers.domain.Gateway;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


/**
 * 长链接接入网关视图对象 t_gateway
 *
 * @author Lion Li
 * @date 2023-11-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Gateway.class)
public class GatewayVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * gateway网关地址
     */
    @ExcelProperty(value = "gateway网关地址")
    private String url;

    /**
     * 订阅消息主题
     */
    @ExcelProperty(value = "订阅消息主题")
    private String topic;

    /**
     * 支持协议：0=全部支持，1=tcp，2=udp，3=websocket
     */
    @ExcelProperty(value = "支持协议：0=全部支持，1=tcp，2=udp，3=websocket")
    private Long protocol;

    /**
     * 注册密钥
     */
    @ExcelProperty(value = "注册密钥")
    private String secretKey;

    /**
     * 注册时间
     */
    @ExcelProperty(value = "注册时间")
    private Date registerTime;

    /**
     * 最大连接总数
     */
    @ExcelProperty(value = "最大连接总数")
    private Long maxConnectionNumber;

    /**
     * 剩余连接数
     */
    @ExcelProperty(value = "剩余连接数")
    private Long remainingConnectionNumber;


}
