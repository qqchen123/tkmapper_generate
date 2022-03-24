//package com.myxx.tktest.utils.result.handler;
//
//
//import cn.soboys.core.utils.HttpContextUtil;
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//
//import javax.servlet.http.HttpServletRequest;
//
//@Slf4j
//@ControllerAdvice
//public class ResponseResultHandler {
//    public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";
//
//    /**
//     * @param methodParameter
//     * @param aClass
//     * @return 此处如果返回false , 则不执行当前Advice的业务
//     * 是否请求包含了包装注解 标记，没有直接返回不需要重写返回体，
//     */
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//        HttpServletRequest request = HttpContextUtil.getRequest();
//        //判断请求是否有包装标志
//        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
//        return responseResultAnn == null ? false : true;
//    }
//
//    /**
//     * @param body
//     * @param methodParameter
//     * @param mediaType
//     * @param aClass
//     * @param serverHttpRequest
//     * @param serverHttpResponse
//     * @return 处理响应的具体业务方法
//     */
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        if (body instanceof Result) {
//            return body;
//        } else if (body instanceof String) {
//            return JSON.toJSONString(ResultResponse.success(body));
//        } else {
//            return ResultResponse.success(body);
//        }
//    }
//}
