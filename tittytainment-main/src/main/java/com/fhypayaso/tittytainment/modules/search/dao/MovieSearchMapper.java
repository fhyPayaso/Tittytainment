package com.fhypayaso.tittytainment.modules.search.dao;

import com.fhypayaso.tittytainment.pojo.entity.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/23 5:00 下午
#   @Description   : 
# ====================================================*/
public interface MovieSearchMapper extends ElasticsearchRepository<Movie, Long> {

    List<Movie> findByName(String name);

    List<Movie> findByStorylineLike(String storyline);

    List<Movie> findByNameOrStoryline(String name,String storyline, Pageable pageable);
}
