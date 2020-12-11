package com.fantasy.code.leetcode.editor.cn.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author zhuo
 * @date 2020-12-11 16:36
 */
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Resolved {
}
