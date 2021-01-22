package com.fhypayaso.tittytainment.modules.message.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/22 4:20 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class MessageVO {

    private Long id;

    private Integer type;

    private Long typeId;

    private Long fromUserId;

    private Long sendUserId;

    private Boolean hasRead;

    private String sendTime;

    private String message;
}
