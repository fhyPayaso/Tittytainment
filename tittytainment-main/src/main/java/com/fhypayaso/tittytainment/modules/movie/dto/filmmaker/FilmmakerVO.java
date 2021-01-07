package com.fhypayaso.tittytainment.modules.movie.dto.filmmaker;

import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/3 1:15 上午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class FilmmakerVO {

    private Long id;

    private Long doubanId;

    private String name;

    private String nameEn;

    private String nameZh;

    private String sex;

    private String birth;

    private String birthPlace;

    private String constellation;

    private String biography;

    private List<MovieVO> movies;

}
