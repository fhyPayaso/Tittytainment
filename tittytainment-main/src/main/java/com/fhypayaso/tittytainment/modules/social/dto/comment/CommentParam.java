package com.fhypayaso.tittytainment.modules.social.dto.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/11 12:39 上午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class CommentParam {

    private Long id;

    @JsonProperty("post_id")
    private Long postId;

    private String content;
}
