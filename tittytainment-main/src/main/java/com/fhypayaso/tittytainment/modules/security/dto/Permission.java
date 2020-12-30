package com.fhypayaso.tittytainment.modules.security.dto;

import com.fhypayaso.tittytainment.exception.ApiException;
import org.omg.CORBA.PUBLIC_MEMBER;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/30 12:32 下午
#   @Description   : 
# ====================================================*/
public enum Permission {


    ADMIN(1, "ADMIN","超级管理员，拥有所有权限"),

    USER(2, "USER","普通注册用户");


    private Integer id;

    private String name;

    private String description;



    private Permission(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }
}
