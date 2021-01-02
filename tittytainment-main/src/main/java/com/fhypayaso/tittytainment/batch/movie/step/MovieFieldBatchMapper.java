package com.fhypayaso.tittytainment.batch.movie.step;

import com.fhypayaso.tittytainment.batch.movie.MovieBatchConfig;
import com.fhypayaso.tittytainment.batch.movie.dto.MovieBatchDto;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/1 4:06 下午
#   @Description   : 将csv中的全部字段提取出来
# ====================================================*/
public class MovieFieldBatchMapper implements FieldSetMapper<MovieBatchDto> {

    @Override
    public MovieBatchDto mapFieldSet(FieldSet fieldSet) throws BindException {

        String[] fieldNames = MovieBatchConfig.fieldNames();

        MovieBatchDto dto = new MovieBatchDto();
        dto.setMovieId(fieldSet.readLong(fieldNames[0]));
        dto.setName(fieldSet.readString(fieldNames[1]));
        dto.setAlias(fieldSet.readString(fieldNames[2]));
        dto.setActors(fieldSet.readString(fieldNames[3]));
        dto.setCover(fieldSet.readString(fieldNames[4]));

        dto.setDirectors(fieldSet.readString(fieldNames[5]));
        dto.setDoubanScore(fieldSet.readDouble(fieldNames[6]));
        dto.setDoubanVotes(fieldSet.readLong(fieldNames[7]));
        dto.setGenres(fieldSet.readString(fieldNames[8]));
        dto.setImdbId(fieldSet.readString(fieldNames[9]));

        dto.setLanguages(fieldSet.readString(fieldNames[10]));
        dto.setMins(fieldSet.readInt(fieldNames[11]));
        dto.setOfficialSite(fieldSet.readString(fieldNames[12]));
        dto.setRegions(fieldSet.readString(fieldNames[13]));
        dto.setReleaseDate(fieldSet.readString(fieldNames[14]));

        dto.setSlug(fieldSet.readString(fieldNames[15]));
        dto.setStoryline(fieldSet.readString(fieldNames[16]));
        dto.setTags(fieldSet.readString(fieldNames[17]));
        dto.setYear(fieldSet.readInt(fieldNames[18]));
        dto.setActorIds(fieldSet.readString(fieldNames[19]));
        dto.setDirectorIds(fieldSet.readString(fieldNames[20]));


        return dto;
    }
}
