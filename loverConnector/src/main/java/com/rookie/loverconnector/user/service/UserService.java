package com.rookie.loverconnector.user.service;

import com.rookie.loverconnector.user.vo.UserVO;
import com.rookie.loverconnector.user.vo.request.UserInfo;
import com.rookie.loverconnector.vo.MsgResponse;

/**
 * @author WebRookie
 * @date 2023/7/19 16:42
 **/
public interface UserService {

    /**
     * 小程序用户登录业务
     * @param jsCode
     * @return
     */
    MsgResponse<UserVO> login(String jsCode);

    /**
     * 根据Id查询用户信息
     * @param userId
     * @return
     */
    MsgResponse<UserVO> getUserInfo(int userId);

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    MsgResponse updateUserInfo(UserInfo userInfo);
}
