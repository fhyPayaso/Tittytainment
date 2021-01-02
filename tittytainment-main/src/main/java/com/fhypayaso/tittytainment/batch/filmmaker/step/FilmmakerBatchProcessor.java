package com.fhypayaso.tittytainment.batch.filmmaker.step;

import com.fhypayaso.tittytainment.batch.filmmaker.dto.FilmmakerBatchDto;
import com.fhypayaso.tittytainment.batch.filmmaker.dto.FilmmakerExtraDto;
import com.fhypayaso.tittytainment.batch.movie.dto.MovieBatchDto;
import com.fhypayaso.tittytainment.pojo.entity.Filmmaker;
import com.fhypayaso.tittytainment.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 5:00 下午
#   @Description   : 
# ====================================================*/
@Slf4j
public class FilmmakerBatchProcessor implements ItemProcessor<FilmmakerBatchDto, FilmmakerBatchDto> {

    @Override
    public FilmmakerBatchDto process(FilmmakerBatchDto dto) throws Exception {

//        log.info(dto.toString());
        dto.setFilmmaker(parseFilmmaker(dto));
        dto.setFilmmakerExtraDto(parseFilmmakerExtra(dto));
        return dto;
    }


    private Filmmaker parseFilmmaker(FilmmakerBatchDto dto) {

        Filmmaker filmmaker = new Filmmaker();

        filmmaker.setDoubanId(dto.getPersonId());
        filmmaker.setSex(dto.getSex());
        filmmaker.setName(dto.getName());
        filmmaker.setNameEn(dto.getNameEn());
        filmmaker.setNameZh(dto.getNameZh());
        filmmaker.setConstellation(dto.getConstellation());
        filmmaker.setBirthPlace(dto.getBirthPlace());
        filmmaker.setBiography(dto.getBiography());
        // 出生日期
        String birthTime = dto.getBirth();
        if (!StringUtils.isEmpty(birthTime)) {
            filmmaker.setBirth(DateUtil.formatSlashStr2Date(birthTime));

        }

        return filmmaker;
    }


    private FilmmakerExtraDto parseFilmmakerExtra(FilmmakerBatchDto dto) {
        FilmmakerExtraDto filmmakerExtraDto = new FilmmakerExtraDto();

        String professionList = dto.getProfession();

        if (!StringUtils.isEmpty(professionList)) {
            List<String> list = new ArrayList<>(Arrays.asList(professionList.split("/")));
            filmmakerExtraDto.setProfessionList(list.stream().map(String::trim).collect(Collectors.toList()));
        }

        return filmmakerExtraDto;
    }

}
