package com.fhypayaso.tittytainment.modules.social.dto.post;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 9:46 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class PostParam {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private Long topicId;

    @NotNull
    private Integer postType;

    private Long movieId;

}
