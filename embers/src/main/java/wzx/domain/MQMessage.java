package wzx.domain;

import java.io.Serializable;
import java.util.Arrays;

public class MQMessage implements Serializable {

    private Integer id;
    private String fromTopic;

    private String toTopic;

    private byte[] data;

    public MQMessage(Integer id, String fromTopic, String toTopic, byte[] data) {
        this.id = id;
        this.fromTopic = fromTopic;
        this.toTopic = toTopic;
        this.data = data;
    }

    public MQMessage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromTopic() {
        return fromTopic;
    }

    public void setFromTopic(String fromTopic) {
        this.fromTopic = fromTopic;
    }

    public String getToTopic() {
        return toTopic;
    }

    public void setToTopic(String toTopic) {
        this.toTopic = toTopic;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MQMessage{" +
                "id=" + id +
                ", fromTopic='" + fromTopic + '\'' +
                ", toTopic='" + toTopic + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public static MQMessage build(Integer id, String fromTopic, String toTopic, byte[] data){
        return new MQMessage(id,fromTopic,toTopic,data);
    }
    public static MQMessage build(Integer id,String fromTopic,String toTopic){
        return build(id,fromTopic,toTopic,null);
    }
}
