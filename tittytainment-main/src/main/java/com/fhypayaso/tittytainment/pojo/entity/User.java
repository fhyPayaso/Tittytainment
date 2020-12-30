package com.fhypayaso.tittytainment.pojo.entity;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/25 1:28 上午
#   @Description   : 
# ====================================================*/

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {


    private static final long serialVersionUID = -634026337147466383L;


    private Integer id;

    private String phone;

    private String password;

    private String name;

    private String coverUrl;

    private Boolean status;

    private Date createdTime;

    private Date updatedTime;

}
