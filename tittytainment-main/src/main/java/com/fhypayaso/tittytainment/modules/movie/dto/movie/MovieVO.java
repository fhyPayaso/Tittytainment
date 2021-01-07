package com.fhypayaso.tittytainment.modules.movie.dto.movie;

import com.fhypayaso.tittytainment.base.BasePVO;
import com.fhypayaso.tittytainment.modules.movie.dto.category.CategoryVO;
import com.fhypayaso.tittytainment.modules.movie.dto.language.LanguageVO;
import com.fhypayaso.tittytainment.modules.movie.dto.ProfessionVO;
import com.fhypayaso.tittytainment.modules.movie.dto.region.RegionVO;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/3 12:11 上午
#   @Description   : 电影相应类
# ====================================================*/
@Data
@ToString
public class MovieVO extends BasePVO {

    private Long id;

    private Long doubanId;

    private String name;

    private String alias;

    private String coverUrl;

    private Double doubanScore;

    private Long doubanVote;

    private Integer mins;

    private String releaseDate;

    private Integer year;

    private String storyline;

    private String tags;


    /* 电影发行的语言 */
    private List<LanguageVO> languages;


    /* 电影发行的地区 */
    private List<RegionVO> regions;

    /* 电影所属的分类 */
    private List<CategoryVO> categories;

    /* 电影演职人员信息 */
    private List<ProfessionVO> professions;

}
