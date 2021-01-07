package com.fhypayaso.tittytainment.modules.movie.service.impl;

import com.fhypayaso.tittytainment.dao.FilmmakerProfessionMapper;
import com.fhypayaso.tittytainment.dao.ProfessionMapper;
import com.fhypayaso.tittytainment.modules.movie.dto.ProfessionVO;
import com.fhypayaso.tittytainment.modules.movie.service.ProfessionService;
import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;
import com.fhypayaso.tittytainment.pojo.entity.FilmmakerProfession;
import com.fhypayaso.tittytainment.pojo.entity.Profession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.peer.PanelPeer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:28 上午
#   @Description   : 职业service
# ====================================================*/
@Slf4j
@Service
public class ProfessionServiceImpl implements ProfessionService {

    @Resource
    private ProfessionMapper professionMapper;

    @Resource
    private FilmmakerProfessionMapper filmmakerProfessionMapper;


    @Override
    public Long insert(String professionName) {

        Profession profession = new Profession();
        profession.setName(professionName);
        profession.setCreatedTime(new Date(System.currentTimeMillis()));
        profession.setUpdatedTime(new Date(System.currentTimeMillis()));
        professionMapper.insert(profession);

        return profession.getId();
    }

    @Override
    public int insertFilmmakerProfession(Filmmaker filmmaker, Long professionId) {

        FilmmakerProfession filmmakerProfession = new FilmmakerProfession();
        filmmakerProfession.setFilmmakerId(filmmaker.getId());
        filmmakerProfession.setFilmmakerDoubanId(filmmaker.getDoubanId());
        filmmakerProfession.setProfessionId(professionId);
        filmmakerProfession.setCreatedTime(new Date(System.currentTimeMillis()));
        filmmakerProfession.setUpdatedTime(new Date(System.currentTimeMillis()));

        return filmmakerProfessionMapper.insert(filmmakerProfession);
    }

    @Override
    public int deleteAll() {
        return professionMapper.deleteAll();
    }

    @Override
    public int deleteAllFilmmakerProfession() {
        return filmmakerProfessionMapper.deleteAll();
    }

    @Override
    public Profession queryByName(String name) {
        return professionMapper.selectByName(name);
    }

    /**
     * 查询电影中所包含的职业
     * @param movieId
     * @return
     */
    @Override
    public List<ProfessionVO> queryByMovie(Long movieId) {

        List<ProfessionVO> professionList = new ArrayList<>();
//        List<Filmmaker> filmmakerList = filmmakerProfessionMapper
        return professionList;
    }


    @Override
    public Profession queryById(Long id) {
        return professionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int update(Profession profession) {
        return 0;
    }

    @Override
    public List<Profession> queryAll() {
        return null;
    }
}
