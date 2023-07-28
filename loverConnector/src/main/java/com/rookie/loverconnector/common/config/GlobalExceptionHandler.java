package com.rookie.loverconnector.common.config;

import com.rookie.loverconnector.common.constants.ApiException;
import com.rookie.loverconnector.common.constants.CodeEnum;
import com.rookie.loverconnector.vo.MsgResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WebRookie
 * @date 2023/7/24 10:09
 **/
@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 请求参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public MsgResponse MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数校验异常");
        List<String> defaultMsg = e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> "[" + fieldError.getField() + "]" + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        return new MsgResponse(CodeEnum.PARAM_ERROR, defaultMsg);
    }

    /**
     * 自定义接口异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public MsgResponse apiExceptionHandler(final ApiException e) {
        log.error("api 请求异常");
        return new MsgResponse(CodeEnum.REQUEST_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public MsgResponse handleDefaultException (Exception e) {
        log.info("服务异常");
        log.error("{},{}",e.getMessage(),e);
        return new MsgResponse(CodeEnum.SERVICE_ERROR);
    }
}
