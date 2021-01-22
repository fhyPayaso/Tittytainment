package com.fhypayaso.tittytainment.modules.app.service;

import com.fhypayaso.tittytainment.exception.ApiException;
import com.fhypayaso.tittytainment.modules.app.pojo.AppConfigDTO;
import com.fhypayaso.tittytainment.modules.app.pojo.AppConfigVO;
import com.fhypayaso.tittytainment.pojo.entity.AppConfig;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/22 8:10 下午
#   @Description   : 
# ====================================================*/
public interface AppConfigService {


    void createVersionConfig(AppConfigDTO dto) throws ApiException;

    List<AppConfigVO> queryAllVersion();

    AppConfigVO lastVersion();


}
