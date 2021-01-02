package com.fhypayaso.tittytainment.batch.movie.dto;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 9:31 上午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class MovieExtraDto {


    /* 电影所属类别 */
    private List<String> categoryList;

    /* 电影语言版本 */
    private List<String> languageList;


    /* 上映地区 */
    private List<String> regionList;


    /* 演员id列表 */
    private List<Long> actorIdList;

    /* 导演id列表 */
    private List<Long> directorIdList;

}
