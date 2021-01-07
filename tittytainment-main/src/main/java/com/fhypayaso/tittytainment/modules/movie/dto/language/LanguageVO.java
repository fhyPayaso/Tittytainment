package com.fhypayaso.tittytainment.modules.movie.dto.language;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/3 11:05 上午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class LanguageVO {

    private Long id;

    @JsonProperty("language_name")
    private String languageName;
}
