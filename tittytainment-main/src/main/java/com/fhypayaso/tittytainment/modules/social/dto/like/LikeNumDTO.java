package com.fhypayaso.tittytainment.modules.social.dto.like;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/21 1:26 上午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class LikeNumDTO {

    private Integer type;

    private Long postId;

    private Long commentId;

    private Long likeNum;
}
