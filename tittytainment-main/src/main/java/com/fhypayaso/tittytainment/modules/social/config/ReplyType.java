package com.fhypayaso.tittytainment.modules.social.config;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/11 2:01 上午
#   @Description   : 
# ====================================================*/
public enum ReplyType {

    TO_COMMENT(1, "to_comment"),
    TO_REPLY(0, "to_reply");


    private Integer value;

    private String name;

    ReplyType(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }


    public String getName() {
        return name;
    }

    public boolean check(Integer type) {
        return value.equals(type);
    }
}
