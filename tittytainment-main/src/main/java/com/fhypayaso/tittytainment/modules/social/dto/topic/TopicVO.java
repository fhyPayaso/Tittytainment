package com.fhypayaso.tittytainment.modules.social.dto.topic;

import com.fhypayaso.tittytainment.base.BasePVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 9:27 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class TopicVO extends BasePVO {

    private Long id;

    private String name;

    private Long createUserId;

    private Long postNum;

    private Long userNum;

    private String topicAbstract;
}
