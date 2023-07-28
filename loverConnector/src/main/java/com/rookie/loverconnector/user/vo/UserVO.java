package com.rookie.loverconnector.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

/**
 * @author WebRookie
 * @date 2023/7/19 16:48
 **/
@Data
@ApiModel("用户详情")
public class UserVO {

    @ApiModelProperty(value="用户id")
    private Integer userId;

    @ApiModelProperty(value="用户名称")
    private String nickname;

    @ApiModelProperty(value="用户手机号")
    private String phone;

    @ApiModelProperty(value="用户是否被关联 0-无关联、1-有关联")
    private String isRelated;

    @ApiModelProperty(value="用户创建时间")
    private Date createDate;

    @ApiModelProperty(value="用户唯一openId")
    private String openId;

    @ApiModelProperty(value="用户更新时间")
    @JsonFormat
    private Date updateDate;

    @ApiModelProperty(value = "用户accessToken")
    private String accessToken;
}
