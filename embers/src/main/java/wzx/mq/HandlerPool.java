package wzx.mq;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 存储数据处理器
 */
public class HandlerPool {

    private static ConcurrentHashMap<Integer,MessageHandler> handlerMap = new ConcurrentHashMap<>();


    public static void add(Integer messageId,MessageHandler handler){
        handlerMap.put(messageId,handler);
    }

    public static boolean containsMessageId(Integer messageId){
        return handlerMap.containsKey(messageId);
    }

    public static void remove(Integer meaageId){
        handlerMap.remove(meaageId);
    }

    public static MessageHandler get(Integer messageId){
        return handlerMap.get(messageId);
    }
}
