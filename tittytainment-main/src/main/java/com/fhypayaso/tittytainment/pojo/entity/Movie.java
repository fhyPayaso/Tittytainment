package com.fhypayaso.tittytainment.pojo.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Movie implements Serializable {
    private static final long serialVersionUID = -1420290980296352145L;
    private Long id;

    private Long doubanId;

    private String name;

    private String alias;

    private String coverUrl;

    private Double doubanScore;

    private Long doubanVote;

    private Integer mins;

    private Date releaseDate;

    private Integer year;

    private Date createdTime;

    private Date updatedTime;

    private String storyline;

    private String tags;
}