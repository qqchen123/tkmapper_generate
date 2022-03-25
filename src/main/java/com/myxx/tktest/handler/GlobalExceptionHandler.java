package com.myxx.tktest.handler;


import com.myxx.tktest.utils.result.Result;
import com.myxx.tktest.utils.result.ResultCode;
import com.myxx.tktest.utils.result.ResultResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 认证异常
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    public Result UnNoException(AuthenticationException e) {
        return ResultResponse.failure(ResultCode.UNAUTHORIZED,e.getMessage());
    }

    /**
     *
     * @param e 未知异常捕获
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result UnNoException(Exception e) {
        System.out.println(e.getMessage());
        return ResultResponse.failure(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
