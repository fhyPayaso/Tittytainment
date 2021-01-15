package com.fhypayaso.tittytainment.modules.social.dto.topic;

import com.fhypayaso.tittytainment.base.BaseQVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 8:20 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class TopicParam extends BaseQVO {

    Long id;

    @NotBlank
    private String name;

    private String topicAbstract;

    @ApiParam("话题类型: 0为常规话题，1为电影话题")
    private Integer topicType;

    private Long movieId;
}
