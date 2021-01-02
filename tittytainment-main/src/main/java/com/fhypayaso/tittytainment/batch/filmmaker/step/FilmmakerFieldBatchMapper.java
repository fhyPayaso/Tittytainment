package com.fhypayaso.tittytainment.batch.filmmaker.step;

import com.fhypayaso.tittytainment.batch.filmmaker.FilmmakerBatchConfig;
import com.fhypayaso.tittytainment.batch.filmmaker.dto.FilmmakerBatchDto;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 4:53 下午
#   @Description   : 
# ====================================================*/
public class FilmmakerFieldBatchMapper implements FieldSetMapper<FilmmakerBatchDto> {

    @Override
    public FilmmakerBatchDto mapFieldSet(FieldSet fieldSet) throws BindException {

        String[] fieldNames = FilmmakerBatchConfig.fieldNames();

        FilmmakerBatchDto dto = new FilmmakerBatchDto();
        dto.setPersonId(fieldSet.readLong(fieldNames[0]));
        dto.setName(fieldSet.readString(fieldNames[1]));
        dto.setSex(fieldSet.readString(fieldNames[2]));
        dto.setNameEn(fieldSet.readString(fieldNames[3]));
        dto.setNameZh(fieldSet.readString(fieldNames[4]));

        dto.setBirth(fieldSet.readString(fieldNames[5]));
        dto.setBirthPlace(fieldSet.readString(fieldNames[6]));
        dto.setConstellation(fieldSet.readString(fieldNames[7]));
        dto.setProfession(fieldSet.readString(fieldNames[8]));
        dto.setBiography(fieldSet.readString(fieldNames[9]));

        return dto;
    }
}
