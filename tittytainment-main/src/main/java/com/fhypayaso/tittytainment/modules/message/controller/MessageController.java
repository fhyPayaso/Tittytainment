package com.fhypayaso.tittytainment.modules.message.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.message.dto.MessageTypeVO;
import com.fhypayaso.tittytainment.modules.message.dto.MessageVO;
import com.fhypayaso.tittytainment.modules.message.service.MessageService;
import com.fhypayaso.tittytainment.pojo.entity.Message;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/22 2:53 下午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/message")
public class MessageController {


    @Resource
    private MessageService messageService;

    @GetMapping("/type")
    @ApiOperation("获取全部消息类型")
    CommonResult<List<MessageTypeVO>> queryTypeList() {
        List<MessageTypeVO> voList = messageService.queryAllMessageType();
        return CommonResult.success(voList, "查询成功");
    }


    @GetMapping("/read/{msg_id}")
    @ApiOperation("读取消息")
    CommonResult<Void> readMessage(@PathVariable("msg_id") Long msgId) throws ApiException {
        messageService.readMessage(msgId);
        return CommonResult.success("消息读取成功");
    }


    @PostMapping("/system")
    @ApiOperation("创建系统消息")
    CommonResult<Void> createSystemMessage(@RequestParam("msg")
                                           @NotBlank String msg) throws ApiException {
        messageService.createSystemMessage(msg);
        return CommonResult.success("系统消息创建成功");
    }


    @GetMapping("/list")
    @ApiOperation("获取某个类型的全部消息")
    CommonResult<PageInfo<MessageVO>> queryMessagesByType(@RequestParam("type_id") Integer typeId,
                                                          @RequestParam("offset") Integer offset,
                                                          @RequestParam("count") Integer count) throws ApiException {
        PageInfo<MessageVO> pageInfo = messageService.queryMessagesByType(typeId, offset, count);
        return CommonResult.success(pageInfo, "查询成功");
    }


}
