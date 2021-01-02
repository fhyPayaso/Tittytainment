package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.pojo.entity.Category;
import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:14 上午
#   @Description   : 
# ====================================================*/
public interface FilmmakerService {

    int insert(Filmmaker filmmaker);

    int deleteAll();

    Filmmaker queryByDoubanId(Long dbId);

    Filmmaker queryById(Long id);

    int deleteById(Long id);

    int update(Filmmaker filmmaker);

    List<Filmmaker> queryAll();
}
