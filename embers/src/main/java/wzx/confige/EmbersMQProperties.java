package wzx.confige;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "embers")
public class EmbersMQProperties {

    /**
     * 角色类型: admin,app,gateway
     * admim:控制台应用
     * gateway：连接网关
     * app: 第三方应用
     *
     */
    private String type="admin";

    private Integer maxConnectionNumber;

    private String secretKey;
    /**
     * 默认数据结构
     */
    @Value("${rocketmq.consumer.topic}")
    private String topic;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getMaxConnectionNumber() {
        return maxConnectionNumber;
    }

    public void setMaxConnectionNumber(Integer maxConnectionNumber) {
        this.maxConnectionNumber = maxConnectionNumber;
    }

    //    @PostConstruct
//    public void init(){
//        if (type.equals("admin")){
//            topic = "admin";
//        } else if (type.equals("gateway")) {
//            topic = GenUtil.generateUniqueString();
//        }
//    }

}
