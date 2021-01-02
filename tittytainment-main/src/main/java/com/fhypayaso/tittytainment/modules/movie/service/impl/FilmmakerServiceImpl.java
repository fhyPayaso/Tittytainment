package com.fhypayaso.tittytainment.modules.movie.service.impl;

import com.fhypayaso.tittytainment.dao.FilmmakerMapper;
import com.fhypayaso.tittytainment.dao.MovieFilmmakerMapper;
import com.fhypayaso.tittytainment.modules.movie.service.FilmmakerService;
import com.fhypayaso.tittytainment.modules.movie.service.ProfessionService;
import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:26 上午
#   @Description   : 
# ====================================================*/
@Slf4j
@Service
public class FilmmakerServiceImpl implements FilmmakerService {


    @Resource
    private FilmmakerMapper filmmakerMapper;


    @Resource
    private MovieFilmmakerMapper movieFilmmakerMapper;


    @Resource
    private ProfessionService professionService;


    @Override
    public int insert(Filmmaker filmmaker) {

        filmmaker.setCreatedTime(new Date(System.currentTimeMillis()));
        filmmaker.setUpdatedTime(new Date(System.currentTimeMillis()));
        return filmmakerMapper.insert(filmmaker);
    }

    @Override
    public int deleteAll() {
        return filmmakerMapper.deleteAll();
    }

    @Override
    public Filmmaker queryByDoubanId(Long dbId) {
        return filmmakerMapper.selectByDoubanId(dbId);
    }


    @Override
    public Filmmaker queryById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int update(Filmmaker filmmaker) {
        return 0;
    }

    @Override
    public List<Filmmaker> queryAll() {
        return null;
    }
}
