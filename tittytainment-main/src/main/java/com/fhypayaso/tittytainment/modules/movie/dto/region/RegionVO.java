package com.fhypayaso.tittytainment.modules.movie.dto.region;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/3 11:06 上午
#   @Description   : 
# ====================================================*/
@Data
@ToString
public class RegionVO {

    private Long id;

    @JsonProperty("region_name")
    private String regionName;
}
