package com.rookie.loverconnector.user.service;

import com.rookie.loverconnector.user.vo.UserVO;

/**
 * @author WebRookie
 * @date 2023/7/19 16:42
 **/
public interface UserService {

    UserVO login(String jsCode);
}
