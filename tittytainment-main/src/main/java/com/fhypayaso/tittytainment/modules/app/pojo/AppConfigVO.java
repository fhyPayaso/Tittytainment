package com.fhypayaso.tittytainment.modules.app.pojo;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/22 8:14 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class AppConfigVO {

    private Long id;

    private String versionCode;

    private String resourceUrl;

    private String updatedTime;

    private String updateInfo;
}
