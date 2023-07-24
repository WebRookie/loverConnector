package com.rookie.loverconnector.user.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author WebRookie
 * @date 2023/7/20 09:58
 **/
@Data
public class LoginRequest {
    @NotNull
    @ApiModelProperty(value = "小程序登录jscode", name = "jscode", required = true)
    public String jsCode;
}
