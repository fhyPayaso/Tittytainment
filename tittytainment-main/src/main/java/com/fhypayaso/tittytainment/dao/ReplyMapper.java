package com.fhypayaso.tittytainment.dao;

import com.fhypayaso.tittytainment.pojo.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Reply record);

    Reply selectByPrimaryKey(Long id);

    List<Reply> selectByComment(Long commentId);

    List<Reply> selectAll();

    int updateByPrimaryKey(Reply record);

    int deleteByComment(Long commentId);
}