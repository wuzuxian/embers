package wzx.mq;


import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import wzx.confige.EmbersMQProperties;
import wzx.domain.MQMessage;
import wzx.enums.MessgeType;
import wzx.enums.Protocol;
import wzx.gateway.params.RegisterParam;
import wzx.utils.GsonUtil;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class SendUtil {


    @Value("${rocketmq.consumer.topic}")
    private String consumerTopic;
    @Resource
    private EmbersMQProperties embersMQProperties;


    private static final int MAX_SEND_COUNT = 5;
    private static SendCallback callback = new SendCallback() {
        @Override
        public void onSuccess(SendResult sendResult) {
            //1.成功发送数据
        }

        @Override
        public void onException(Throwable throwable) {

        }
    };
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    public void setRocketMQTemplate(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    public RocketMQTemplate getRocketMQTemplate() {
        return rocketMQTemplate;
    }


    public void sendMessage(String toTopic,int messageId, byte[] data){
        MQMessage mqMessage = MQMessage.build(messageId,consumerTopic, toTopic, data);
        Map<String,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("sendCount",0);
        MessageHeaders headers = new MessageHeaders(map);
        Message<MQMessage> message = MessageBuilder.withPayload(mqMessage).build();
        rocketMQTemplate.asyncSend(toTopic+":embers",message,callback);
    }


    @PostConstruct
    public void init() {
        //如果是app或者gateway需要进行注册到admin
        if (embersMQProperties.getType().equals("app")){
           registerApplication();
        }else if (embersMQProperties.getType().equals("gateway")){
            registerGateway();
        }
    }

    /**
     * 注册gateway
     */
    private void registerGateway() {
        RegisterParam registerParam = new RegisterParam();
        registerParam.setProtocol(Protocol.ALL.getCode());
        registerParam.setTopic(consumerTopic);
        registerParam.setMaxConnectionNumber(embersMQProperties.getMaxConnectionNumber());
        registerParam.setSecretKey(embersMQProperties.getSecretKey());
        byte[] data = GsonUtil.getJsonString(registerParam).getBytes(StandardCharsets.UTF_8);
        sendMessage("admin", MessgeType.GATEWAY_REGISTER.getCode(),data);
    }

    /**
     * 注册app信息
     */
    private void registerApplication() {

    }

}
