package com.rookie.loverconnector.user.controller;

import com.rookie.loverconnector.user.service.UserService;
import com.rookie.loverconnector.user.vo.UserVO;
import com.rookie.loverconnector.user.vo.request.LoginRequest;
import com.rookie.loverconnector.vo.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author WebRookie
 * @date 2023/7/19 16:17
 **/
@RestController
@Api(value="用户controller", tags="用户管理相关接口")
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", httpMethod = "POST")
    public MsgResponse<UserVO> login(@Validated @RequestBody LoginRequest request) {
        return userService.login(request.getJsCode());
    }

}
