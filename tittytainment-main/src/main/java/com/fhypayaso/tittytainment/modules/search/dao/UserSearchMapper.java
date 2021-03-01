package com.fhypayaso.tittytainment.modules.search.dao;

import com.fhypayaso.tittytainment.pojo.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/23 9:02 下午
#   @Description   : 
# ====================================================*/
public interface UserSearchMapper extends ElasticsearchRepository<User, Integer> {

    List<User> findByNameLike(String name, Pageable pageable);

}
