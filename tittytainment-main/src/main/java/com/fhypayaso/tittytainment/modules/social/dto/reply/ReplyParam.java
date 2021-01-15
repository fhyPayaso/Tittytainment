package com.fhypayaso.tittytainment.modules.social.dto.reply;

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
    private Integer replyType;

    private Long commentId;

    private Long replyId;

    @NotNull
    private Long replyUserId;

    @NotBlank
    private String content;
}
