package com.rookie.loverconnector.user.service;

import com.rookie.loverconnector.user.vo.UserVO;
import com.rookie.loverconnector.user.vo.request.UserInfo;
import com.rookie.loverconnector.vo.MsgResponse;

/**
 * @author WebRookie
 * @date 2023/7/19 16:42
 **/
public interface UserService {

    MsgResponse<UserVO> login(String jsCode);

    MsgResponse<UserVO> getUserInfo(int userId);

    MsgResponse updateUserInfo(UserInfo userInfo);
}
