package org.dromara.embers.domain.bo;

import org.dromara.embers.domain.Gateway;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;

/**
 * 长链接接入网关业务对象 t_gateway
 *
 * @author Lion Li
 * @date 2023-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Gateway.class, reverseConvertGenerate = false)
public class GatewayBo extends BaseEntity {

    /**
     *
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * gateway网关地址
     */
    @NotBlank(message = "gateway网关地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String url;

    /**
     * 订阅消息主题
     */
    @NotBlank(message = "订阅消息主题不能为空", groups = { AddGroup.class, EditGroup.class })
    private String topic;

    /**
     * 支持协议：0=全部支持，1=tcp，2=udp，3=websocket
     */
    @NotNull(message = "支持协议：0=全部支持，1=tcp，2=udp，3=websocket不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long protocol;

    /**
     * 注册密钥
     */
    @NotBlank(message = "注册密钥不能为空", groups = { AddGroup.class, EditGroup.class })
    private String secretKey;

    /**
     * 注册时间
     */
    @NotNull(message = "注册时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date registerTime;

    /**
     * 最大连接总数
     */
    @NotNull(message = "最大连接总数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long maxConnectionNumber;

    /**
     * 剩余连接数
     */
    @NotNull(message = "剩余连接数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long remainingConnectionNumber;


}
