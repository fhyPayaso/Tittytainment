package com.fhypayaso.tittytainment.modules.social.controller;

import com.fhypayaso.tittytainment.api.CommonResult;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.social.dto.topic.TopicParam;
import com.fhypayaso.tittytainment.modules.social.dto.topic.TopicVO;
import com.fhypayaso.tittytainment.modules.social.service.TopicService;
import com.fhypayaso.tittytainment.pojo.entity.Topic;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/10 2:52 上午
#   @Description   : 
# ====================================================*/
@RestController
@RequestMapping("/bbs/topic")
public class TopicController {


    @Resource
    private TopicService topicService;


    @PostMapping("/create")
    @ApiOperation("创建话题")
    CommonResult<Void> createTopic(@RequestBody TopicParam param) throws ApiException {
        topicService.createTopic(param);
        return CommonResult.success("话题创建成功");
    }


    @PostMapping("/update")
    @ApiOperation("更新话题")
    CommonResult<Void> updateTopic(@RequestBody TopicParam param) throws ApiException {
        topicService.updateTopic(param);
        return CommonResult.success("话题更新成功");
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除主题")
    CommonResult<Void> deleteTopic(@PathVariable("id") Long id) throws ApiException {
        topicService.deleteTopic(id);
        return CommonResult.success("删除成功");
    }

    @GetMapping("/commons")
    @ApiOperation("获取全部常规话题, 按照帖子数量排序")
    CommonResult<List<TopicVO>> queryAllCommon() throws ApiException {
        List<TopicVO> voList = topicService.queryAllCommonTopic();
        return CommonResult.success(voList, "查询成功");
    }


}
