package com.fhypayaso.tittytainment.modules.social.dto.reply;

import com.fhypayaso.tittytainment.pojo.entity.Reply;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/16 12:44 上午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class ReplyVO {

    private Long id;

    private Integer replyType;

    private Long commentId;

    private Long replyId;

    private Long userId;

    private Long replyUserId;

    private Boolean status;

    private String content;
}
