package com.fhypayaso.tittytainment.modules.social.config;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 10:02 下午
#   @Description   : 帖子类型
# ====================================================*/
public enum  PostType {

    MOVIE(1, "movie"),
    COMMON(0, "common");


    private Integer value;

    private String name;

    PostType(Integer value, String name) {
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
