package com.rookie.loverconnector.vo;

import com.rookie.loverconnector.common.constants.CodeEnum;

import java.io.Serializable;

/**
 * @author WebRookie
 * @date 2023/7/19 15:36
 **/
public class MsgResponse<T> implements Serializable {

    private String message;
    private T data;
    private int code;

    public MsgResponse(T data) {
        this.data = data;
        this.message = CodeEnum.SUCCESS.getMessage();
        this.code = CodeEnum.SUCCESS.getCode();
    }

    private MsgResponse(CodeEnum codeEnum) {
        this.message = codeEnum.getMessage();
        this.code = codeEnum.getCode();
    }

    public static <T> MsgResponse<T> success(T data) {
        return new MsgResponse<>(data);
    }

    public static <T> MsgResponse<T> success() {
        return (MsgResponse<T>) success("");
    }

    public static <T> MsgResponse<T> error(CodeEnum codeEnum) {
        return new MsgResponse<>(codeEnum);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {

    }
}
