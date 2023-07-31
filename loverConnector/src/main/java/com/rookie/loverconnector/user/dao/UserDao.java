package com.rookie.loverconnector.user.dao;

import com.rookie.loverconnector.user.vo.UserVO;
import com.rookie.loverconnector.user.vo.request.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author WebRookie
 * @date 2023/7/21 18:10
 **/
@Mapper
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

    /**
     * 根据id获取用户
     * @param userId
     * @return
     */
    UserVO getUserByUserId(int userId);

    void updateUserInfo(UserInfo userInfo);
}
