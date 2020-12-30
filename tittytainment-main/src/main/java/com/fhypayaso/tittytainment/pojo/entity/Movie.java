package com.fhypayaso.tittytainment.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/26 12:55 上午
#   @Description   : 
# ====================================================*/
@Data
public class Movie implements Serializable {


    private static final long serialVersionUID = 4214412371530642539L;

    private Integer id;

    private String movieName;

    private String movieAlias;

    private String coverUrl;

    private Double doubanScore;

    private Integer movieMins;

    private String languages;

    private String regions;

    private Date releaseTime;

    private Date createdTime;

    private Date updatedTime;

    private String storyline;
}
