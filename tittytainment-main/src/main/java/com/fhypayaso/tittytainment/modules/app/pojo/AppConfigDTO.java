package com.fhypayaso.tittytainment.modules.app.pojo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/22 8:13 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class AppConfigDTO {

    @NotNull
    private Integer mainVersionCode;

    @NotNull
    private Integer subVersionCode;

    @NotNull
    private Integer grayVersionCode;

    @NotBlank
    private String resourceUrl;

    @NotBlank
    private String updateInfo;
}
