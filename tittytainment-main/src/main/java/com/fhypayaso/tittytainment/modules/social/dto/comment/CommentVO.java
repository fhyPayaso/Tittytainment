package com.fhypayaso.tittytainment.modules.social.dto.comment;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 11:15 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class CommentVO {

    private Long id;

    private Long postId;

    private Long userId;

    private Long likeNum;

    private Date createdTime;

    private Date updatedTime;

    private String content;
}
