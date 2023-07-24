package com.rookie.loverconnector.user.dao;

import com.rookie.loverconnector.user.vo.UserVO;
import org.springframework.stereotype.Repository;

/**
 * @author WebRookie
 * @date 2023/7/21 18:10
 **/
@Repository
public interface UserDao {
    /**
     * 通过openid获取用户信息
     * @param openId
     * @return 用户VO
     */
    UserVO getUserByOpenId(String openId);

    /**
     * 通过openId创建用户
     * @param openId
     * @return
     */
    UserVO createUserByOpenId(String openId);
}
