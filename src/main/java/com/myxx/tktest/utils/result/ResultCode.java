package com.myxx.tktest.utils.result;

import lombok.Getter;

@Getter
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(400, "失败"),
    BAD_REQUEST(400, "Bad Request"),
    /**
     * 未认证
     */
    UNAUTHORIZED(401, "认证失败"),
    /**
     * 接口不存在
     */
    NOT_FOUND(404, "接口不存在"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "系统繁忙"),
    METHOD_NOT_ALLOWED(405, "方法不被允许"),

    /*参数错误:1001-1999*/
    PARAMS_IS_INVALID(1001, "参数无效"),
    PARAMS_IS_BLANK(1002, "参数为空");
    /*用户错误2001-2999*/


    private Integer code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
