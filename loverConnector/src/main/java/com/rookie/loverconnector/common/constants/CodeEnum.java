package com.rookie.loverconnector.common.constants;

/**
 * @description  全局错误码枚举
 * @author WebRookie
 * @date 2023/7/19 15:20
 **/

public enum CodeEnum {

    // 成功
    SUCCESS(0,"success"),
    //
    REQUEST_ERROR(40000, "请求出错"),

    PARAM_ERROR(40001, "参数错误"),
    USER_NOT_EXIST(40002, "用户不存在"),
    // 服务器异常
    SERVICE_ERROR(50000, "服务异常")
    ;

    private final int code;
    private String message;
    CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
