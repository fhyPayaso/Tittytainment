package com.fhypayaso.tittytainment.modules.security.dto.vo;

import lombok.Data;

import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/29 8:42 上午
#   @Description   : 
# ====================================================*/
@Data
public class UserVO {

    private Integer id;

    private String phone;

    private String name;

    private String coverUrl;

    private Boolean status;
}
