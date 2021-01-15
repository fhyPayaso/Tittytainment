package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Reply;
import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Reply record);

    Reply selectByPrimaryKey(Long id);

    List<Reply> selectAll();

    int updateByPrimaryKey(Reply record);
}