package wzx.enums;

/**
 * 内部支持协议
 */
public enum Protocol {
    ALL(0,"全部支持"),
    TCP(1,"tcp"),
    UDP(2,"udp"),
    WEBSOCKET(3,"websocket")
    ;
    private Integer code;
    private String desc;

    Protocol(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Protocol getByCode(int code){
        for (Protocol value : values()) {
            if (value.getCode().intValue()==code){
                return value;
            }
        }
        return null;
    }

}
