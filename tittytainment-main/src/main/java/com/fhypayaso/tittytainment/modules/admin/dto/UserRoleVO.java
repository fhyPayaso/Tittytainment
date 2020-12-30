package com.fhypayaso.tittytainment.modules.admin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/29 2:06 上午
#   @Description   : 
# ====================================================*/
@Data
public class UserRoleVO {


    @JsonProperty(value = "user_id")
    private Integer userId;


    @JsonProperty(value = "role_id")
    private Integer roleId;

}
