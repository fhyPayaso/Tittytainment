package com.fhypayaso.tittytainment.modules.social.dto.like;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/16 5:05 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class LikeParam {

    @NotNull
    private Integer type;

    private Long postId;

    private Long commentId;

    @NotNull
    private Long userId;
}
