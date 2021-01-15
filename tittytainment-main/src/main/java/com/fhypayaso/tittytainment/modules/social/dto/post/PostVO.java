package com.fhypayaso.tittytainment.modules.social.dto.post;

import lombok.Data;
import lombok.ToString;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 10:31 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class PostVO {


    private Long id;

    private String title;

    private Long topicId;

    private Boolean postType;

    private Long movieId;

    private Long createUserId;

    private Long likeNum;

    private Long commentNum;

    private Date lastCommentTime;

    private String content;

}
