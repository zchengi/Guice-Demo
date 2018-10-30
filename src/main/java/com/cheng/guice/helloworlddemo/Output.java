package com.cheng.guice.helloworlddemo;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Retention(RetentionPolicy.RUNTIME) 表示运行时可见接口
 * @BindingAnnotation 表示 Output 是用来给 Guice 绑定看的
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
@interface Output {
}
