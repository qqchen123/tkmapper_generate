package com.myxx.tktest.utils.result;

import java.lang.annotation.*;

/**
 * @author chen
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {
}
