package com.fhypayaso.tittytainment.modules.social.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.social.dto.topic.TopicParam;
import com.fhypayaso.tittytainment.modules.social.dto.topic.TopicVO;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:46 上午
#   @Description   : 圈子
# ====================================================*/
public interface TopicService {

    void createTopic(TopicParam param) throws ApiException;

    void updateTopic(TopicParam param) throws ApiException;

    void deleteTopic(Long topicId) throws ApiException;


    List<TopicVO> queryAllCommonTopic() throws ApiException;

}
