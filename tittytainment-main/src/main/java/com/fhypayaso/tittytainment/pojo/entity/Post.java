package com.fhypayaso.tittytainment.pojo.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Post implements Serializable {
    private static final long serialVersionUID = 3865474734159634899L;
    private Long id;

    private String title;

    private Long topicId;

    private Boolean postType;

    private Long movieId;

    private Long createUserId;

    private Long likeNum;

    private Long commentNum;

    private Date lastCommentTime;

    private Date createdTime;

    private Date updatedTime;

    private String content;


}