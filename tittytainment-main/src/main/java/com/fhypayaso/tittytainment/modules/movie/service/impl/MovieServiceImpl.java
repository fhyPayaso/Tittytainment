package com.fhypayaso.tittytainment.modules.movie.service.impl;

import com.fhypayaso.tittytainment.dao.MovieMapper;
import com.fhypayaso.tittytainment.modules.movie.service.MovieService;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/26 1:12 上午
#   @Description   : 
# ====================================================*/

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Resource
    private MovieMapper movieMapper;

    @Override
    public int insert(Movie user) {
        return 0;
    }

    @Override
    public Movie queryById(Integer id) {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int updateById(User user) {
        return 0;
    }

    @Override
    public List<Movie> queryAll() {
        return null;
    }
}
