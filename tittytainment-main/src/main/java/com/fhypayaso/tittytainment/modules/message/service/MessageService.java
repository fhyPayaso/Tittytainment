package com.fhypayaso.tittytainment.modules.message.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.message.MessageType;
import com.fhypayaso.tittytainment.modules.message.dto.MessageTypeVO;
import com.fhypayaso.tittytainment.modules.message.dto.MessageVO;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/22 2:54 下午
#   @Description   : 
# ====================================================*/
public interface MessageService {


    List<MessageTypeVO> queryAllMessageType();


    PageInfo<MessageVO> queryMessagesByType(Integer typeId, Integer offset, Integer count) throws ApiException;


    void createMessage(MessageType type, Long typeId, Long fromUserId,Long sendUserId);


    void createSystemMessage(String msg) throws ApiException;


    void readMessage(Long msgId) throws ApiException;



}
