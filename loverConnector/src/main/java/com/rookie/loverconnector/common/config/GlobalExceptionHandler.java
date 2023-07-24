package com.rookie.loverconnector.common.config;

import com.rookie.loverconnector.common.constants.ApiException;
import com.rookie.loverconnector.common.constants.CodeEnum;
import com.rookie.loverconnector.vo.MsgResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WebRookie
 * @date 2023/7/24 10:09
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 自定义接口异常
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public MsgResponse apiExceptionHandler(final ApiException e) {
        log.error("api 请求异常");
        return new MsgResponse(CodeEnum.REQUEST_ERROR);
    }

    /**
     * 请求参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MsgResponse MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数校验异常");
        List<String> list = new ArrayList<>();
        if(!e.getBindingResult().getAllErrors().isEmpty()) {
            for (ObjectError error: e.getBindingResult().getAllErrors()) {
                log.error(error.getDefaultMessage().toString());
                list.add(error.getDefaultMessage().toString());
            }
        }

        return new MsgResponse(CodeEnum.PARAM_ERROR, list);
    }
}
