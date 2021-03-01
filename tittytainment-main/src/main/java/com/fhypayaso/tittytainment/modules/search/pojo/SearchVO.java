package com.fhypayaso.tittytainment.modules.search.pojo;

import com.fhypayaso.tittytainment.modules.movie.dto.movie.MovieVO;
import com.fhypayaso.tittytainment.modules.security.dto.vo.UserVO;
import com.fhypayaso.tittytainment.modules.social.dto.post.PostVO;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/23 10:47 上午
#   @Description   : 全局搜索返回体
# ====================================================*/
@Data
@ToString
public class SearchVO {

    List<MovieVO> movieList;

    List<PostVO> postList;

    List<UserVO> userList;

}
