package com.fhypayaso.tittytainment.modules.search.service;

import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.search.pojo.SearchVO;
import com.fhypayaso.tittytainment.modules.security.dto.vo.UserVO;
import com.fhypayaso.tittytainment.modules.social.dto.post.PostVO;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.github.pagehelper.PageInfo;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/23 4:44 下午
#   @Description   : 
# ====================================================*/
public interface SearchService {


    SearchVO unionSearch(String keyword, Integer count);

    PageInfo<MovieVO> movieSearch(String keyword, Integer offset, Integer count);

    PageInfo<PostVO> postSearch(String keyword, Integer offset, Integer count);

    PageInfo<UserVO> userSearch(String keyword, Integer offset, Integer count);


    void saveMovie(Movie movie);

}
