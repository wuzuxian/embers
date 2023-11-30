package wzx.gateway.params;

import java.io.Serializable;

public class RegisterParam implements Serializable {
    private String topic;
    private Integer protocol=0;
    private Integer maxConnectionNumber=65535;
    private String secretKey;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getProtocol() {
        return protocol;
    }

    public void setProtocol(Integer protocol) {
        this.protocol = protocol;
    }

    public Integer getMaxConnectionNumber() {
        return maxConnectionNumber;
    }

    public void setMaxConnectionNumber(Integer maxConnectionNumber) {
        this.maxConnectionNumber = maxConnectionNumber;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "RegisterParam{" +
                "topic='" + topic + '\'' +
                ", protocol=" + protocol +
                ", maxConnectionNumber=" + maxConnectionNumber +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }
}
