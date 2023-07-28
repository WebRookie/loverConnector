package com.rookie.loverconnector.common.constants;

import lombok.Data;

/**
 * @author WebRookie
 * @date 2023/7/24 10:18
 **/
@Data
public class ApiException extends RuntimeException {
    private int code;
    private String message;

    public ApiException(){
        this(CodeEnum.REQUEST_ERROR);
    }

    public ApiException(CodeEnum codeEnum){
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }
}
