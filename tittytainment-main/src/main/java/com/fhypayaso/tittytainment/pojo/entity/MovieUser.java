package com.fhypayaso.tittytainment.pojo.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/7 5:36 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class MovieUser implements Serializable {
    private static final long serialVersionUID = -7468952175429053767L;

    private Long id;

    private Long userId;

    private Long movieId;

    private Long movieDoubanId;

    private Boolean wannaSee;

    private Boolean haveSeen;

    private Double score;

    private Date wannaSeeTime;

    private Date haveSeenTime;

    private Date scoreTime;

    private Date createdTime;

    private Date updatedTime;

}
