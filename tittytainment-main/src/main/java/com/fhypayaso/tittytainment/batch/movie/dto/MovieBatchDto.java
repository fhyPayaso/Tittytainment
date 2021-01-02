package com.fhypayaso.tittytainment.batch.movie.dto;

import com.fhypayaso.tittytainment.pojo.entity.Movie;
import lombok.Data;
import lombok.ToString;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/1 4:37 下午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class MovieBatchDto {

    private Long movieId;

    private String name;

    private String alias;

    private String actors;

    private String cover;

    private String directors;

    private Double doubanScore;

    private Long doubanVotes;

    private String genres;

    private String imdbId;

    private String languages;

    private Integer mins;

    private String officialSite;

    private String regions;

    private String releaseDate;

    private String slug;

    private String storyline;

    private String tags;

    private Integer year;

    private String actorIds;

    private String directorIds;


    private MovieExtraDto movieExtraDto;

    private Movie movieModel;

}
