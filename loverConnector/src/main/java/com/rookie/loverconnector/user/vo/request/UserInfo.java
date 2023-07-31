package com.rookie.loverconnector.user.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author WebRookie
 * @date 2023/7/31 15:17
 **/
@Data
public class UserInfo {

    public interface GetInfo {}
    public interface UpdateInfo {}

    @NotNull(message = "用户id不能为空", groups = {GetInfo.class, UpdateInfo.class})
    @ApiModelProperty(value = "用户id",name="userId", required = true)
    private Integer userId;

//    @NotBlank(message = "用户昵称不能为空", groups = {UpdateInfo.class})
    @ApiModelProperty(value = "用户昵称", name="nickname")
    private String nickname;

    @Pattern(message = "请输入正确的手机号",regexp = "/^1[3-9]\\d{9}$/", groups = {UpdateInfo.class})
    private String phone;

    private String isRelated;

    private String accessToken;
}
