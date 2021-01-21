package com.fhypayaso.tittytainment.modules.social.dto.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fhypayaso.tittytainment.pojo.entity.Reply;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/16 12:17 上午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class ReplyParam {


    private Long id;

    @NotNull
    @JsonProperty("reply_type")
    private Integer replyType;

    @JsonProperty("comment_id")
    private Long commentId;

    @JsonProperty("reply_id")
    private Long replyId;

    @NotNull
    @JsonProperty("reply_user_id")
    private Long replyUserId;

    @NotBlank
    private String content;
}
