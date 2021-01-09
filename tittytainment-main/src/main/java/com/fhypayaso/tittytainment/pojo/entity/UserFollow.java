package com.fhypayaso.tittytainment.pojo.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/7 5:37 下午
#   @Description   : 
# ====================================================*/

@Data
@ToString
public class UserFollow implements Serializable {

    private static final long serialVersionUID = 8791275325683630202L;

    private Long id;

    private Long userId;

    private Long followUserId;

    private Boolean follow;

    private Date createdTime;

    private Date updatedTime;
}
