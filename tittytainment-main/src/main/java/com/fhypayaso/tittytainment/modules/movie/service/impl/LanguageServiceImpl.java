package com.fhypayaso.tittytainment.modules.movie.service.impl;

import com.fhypayaso.tittytainment.dao.LanguageMapper;
import com.fhypayaso.tittytainment.dao.MovieLanguageMapper;
import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.movie.dto.language.LanguageVO;
import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.movie.service.LanguageService;
import com.fhypayaso.tittytainment.modules.movie.service.MovieService;
import com.fhypayaso.tittytainment.pojo.entity.Language;
import com.fhypayaso.tittytainment.pojo.entity.Movie;
import com.fhypayaso.tittytainment.pojo.entity.MovieCategory;
import com.fhypayaso.tittytainment.pojo.entity.MovieLanguage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 12:27 上午
#   @Description   : 
# ====================================================*/
@Slf4j
@Service
public class LanguageServiceImpl implements LanguageService {

    @Resource
    private LanguageMapper languageMapper;

    @Resource
    private MovieLanguageMapper movieLanguageMapper;

    @Resource
    private MovieService movieService;


    @Override
    public Long insert(String name) {

        Language language = new Language();
        language.setLanguageName(name);
        language.setCreatedTime(new Date(System.currentTimeMillis()));
        language.setUpdatedTime(new Date(System.currentTimeMillis()));
        languageMapper.insert(language);

        return language.getId();
    }

    @Override
    public int insertMovieLanguage(Movie movie, Long languageId) {

        MovieLanguage movieLanguage = new MovieLanguage();
        movieLanguage.setMovieId(movie.getId());
        movieLanguage.setMovieDoubanId(movie.getDoubanId());
        movieLanguage.setLanguageId(languageId);
        movieLanguage.setCreatedTime(new Date(System.currentTimeMillis()));
        movieLanguage.setUpdatedTime(new Date(System.currentTimeMillis()));

        return movieLanguageMapper.insert(movieLanguage);
    }

    @Override
    public int deleteAll() {
        return languageMapper.deleteAll();
    }

    @Override
    public int deleteAllMovieLanguage() {
        return movieLanguageMapper.deleteAll();
    }

    @Override
    public Language queryById(Long id) {
        return null;
    }

    @Override
    public List<LanguageVO> queryByMovie(Long id) {

        List<MovieLanguage> movieLanguageList = movieLanguageMapper.selectByMovie(id);

        List<LanguageVO> languages = new ArrayList<>();
        if (!CollectionUtils.isEmpty(movieLanguageList)) {
            for (MovieLanguage ml : movieLanguageList) {
                Language language = languageMapper.selectByPrimaryKey(ml.getLanguageId());
                if (language != null) {
                    LanguageVO vo = new LanguageVO();
                    BeanUtils.copyProperties(language, vo);
                    languages.add(vo);
                }
            }
        }

        return languages;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int update(Language language) {
        return 0;
    }

    @Override
    public List<LanguageVO> queryAll() {

        List<Language> languages = languageMapper.selectAll();

        List<LanguageVO> voList = languages.stream()
                .map(language -> {
                    LanguageVO vo = new LanguageVO();
                    BeanUtils.copyProperties(language, vo);
                    return vo;
                })
                .collect(Collectors.toList());

        return voList;
    }

    @Override
    public PageInfo<MovieVO> queryMovieByLanguage(Long languageId, Integer offset, Integer count) throws ApiException {

        PageHelper.offsetPage(offset, count);

        List<MovieLanguage> movieLanguages = movieLanguageMapper.selectByLanguage(languageId);
        List<MovieVO> voList = new ArrayList<>();

        // 查询当前类别下的所有电影
        for (MovieLanguage mc : movieLanguages) {
            voList.add(movieService.queryById(mc.getMovieId(),false));
        }

        return new PageInfo<>(voList);
    }
}
