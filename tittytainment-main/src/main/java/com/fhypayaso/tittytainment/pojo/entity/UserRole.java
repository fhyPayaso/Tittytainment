package com.fhypayaso.tittytainment.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/27 1:29 上午
#   @Description   : 
# ====================================================*/
@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = -5243457377587528628L;

    private Integer userId;

    private Integer roleId;
}
