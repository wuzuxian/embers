package wzx.mq;

import wzx.domain.MQMessage;

public interface MessageHandler {
    void doHandler(MQMessage message);
}
