package com.rookie.loverconnector.user.service.impl;

import com.rookie.loverconnector.user.service.UserService;
import com.rookie.loverconnector.user.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * @author WebRookie
 * @date 2023/7/19 16:44
 **/
@Service
public class UserServiceImpl implements UserService {


    @Override
    public UserVO login(String jsCode) {
        System.out.println("123");
        return null;
    }
}
