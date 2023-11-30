package wzx.mq;


import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;
import wzx.domain.MQMessage;

@Service
@RocketMQMessageListener(topic ="${rocketmq.consumer.topic}", consumerGroup = "${rocketmq.consumer.group}")
public class EmbersConsumer implements RocketMQListener<MQMessage> {

    @Override
    public void onMessage(MQMessage message) {
        if (HandlerPool.containsMessageId(message.getId())){
            HandlerPool.get(message.getId()).doHandler(message);
        }
    }
}
