package com.fhypayaso.tittytainment.modules.movie.service;

import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;
import com.fhypayaso.tittytainment.pojo.entity.Language;
import com.fhypayaso.tittytainment.pojo.entity.Profession;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:16 上午
#   @Description   : 
# ====================================================*/
public interface ProfessionService {

    Long insert(String professionName);

    int insertFilmmakerProfession(Filmmaker filmmaker, Long professionId);

    int deleteAll();

    int deleteAllFilmmakerProfession();

    Profession queryByName(String name);


    Profession queryById(Long id);

    int deleteById(Long id);

    int update(Profession profession);

    List<Profession> queryAll();
}
