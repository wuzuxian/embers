package wzx.enums;

public enum MessgeType {
    GATEWAY_REGISTER(1,"连接池网关注册"),
    ;
    private Integer code;
    private String desc;

    MessgeType(Integer code, String desc) {
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

    public static MessgeType getByCode(int code){
        for (MessgeType value : values()) {
            if (value.getCode().intValue()==code){
                return value;
            }
        }
        return null;
    }
}
