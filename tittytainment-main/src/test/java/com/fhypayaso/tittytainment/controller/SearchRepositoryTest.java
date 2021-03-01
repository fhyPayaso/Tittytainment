package com.fhypayaso.tittytainment.controller;

import com.fhypayaso.tittytainment.dao.MovieMapper;
import com.fhypayaso.tittytainment.dao.PostMapper;
import com.fhypayaso.tittytainment.dao.UserMapper;
import com.fhypayaso.tittytainment.modules.search.dao.MovieSearchMapper;
import com.fhypayaso.tittytainment.modules.search.dao.PostSearchMapper;
import com.fhypayaso.tittytainment.modules.search.dao.UserSearchMapper;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import javax.annotation.Resource;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/23 4:50 下午
#   @Description   : 
# ====================================================*/
@SpringBootTest
@Slf4j
public class SearchRepositoryTest {

    @Resource
    private MovieSearchMapper movieSearchMapper;

    @Resource
    private PostSearchMapper postSearchMapper;

    @Resource
    private UserSearchMapper userSearchMapper;


    @Resource
    private MovieMapper movieMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private PostMapper postMapper;

    @Resource
    private ElasticsearchRestTemplate template;



    @Test
    void createOrUpdate() {

        //创建&更新
//        Movie movie = new Movie();
//        movie.setId(1L);
//        movie.setName("我和我的家乡");
//        movie.setStoryline("国庆献礼片");
//        movieSearchMapper.save(movie);

//        List<Movie> movies = movieMapper.selectNum(100);
//        movieSearchMapper.saveAll(movies);
//        postSearchMapper.saveAll(postMapper.selectAll());
        userSearchMapper.saveAll(userMapper.selectAll());
    }


    @Test
    void search() {

        List<Movie> movies = movieSearchMapper.findByName("我");
        movies.forEach(m -> log.debug(movies.toString()));

    }


    @Test
    void deleteIndex() {

//        template.deleteIndex("movie");
        template.deleteIndex("titty_user");



    }




}
