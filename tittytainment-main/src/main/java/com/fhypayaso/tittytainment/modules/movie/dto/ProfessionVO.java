package com.fhypayaso.tittytainment.modules.movie.dto;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/3 1:36 上午
#   @Description   : 
# ====================================================*/

import com.fhypayaso.tittytainment.modules.movie.dto.filmmaker.FilmmakerVO;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ProfessionVO {

    private Long id;

    private String name;

    /* 当前岗位有哪些演职人员 */
    private List<FilmmakerVO> filmmakers = new ArrayList<>();


    public void addFilmmakerVO(FilmmakerVO filmmakerVO) {
        filmmakers.add(filmmakerVO);
    }




}
