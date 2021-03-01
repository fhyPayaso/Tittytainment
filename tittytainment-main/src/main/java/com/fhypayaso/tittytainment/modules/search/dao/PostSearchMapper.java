package com.fhypayaso.tittytainment.modules.search.dao;

import com.fhypayaso.tittytainment.pojo.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/23 9:01 下午
#   @Description   : 
# ====================================================*/
public interface PostSearchMapper extends ElasticsearchRepository<Post, Long> {

    List<Post> findByTitleOrContent(String title, String content, Pageable pageable);

}
