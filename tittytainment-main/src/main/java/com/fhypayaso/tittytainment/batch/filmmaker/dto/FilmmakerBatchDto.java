package com.fhypayaso.tittytainment.batch.filmmaker.dto;

import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;
import lombok.Data;
import lombok.ToString;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/1 9:23 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class FilmmakerBatchDto {


    private Long personId;

    private String name;

    private String sex;

    private String nameEn;

    private String nameZh;

    private String birth;

    private String birthPlace;

    private String constellation;

    private String profession;

    private String biography;

    private Filmmaker filmmaker;

    private FilmmakerExtraDto filmmakerExtraDto;

}
