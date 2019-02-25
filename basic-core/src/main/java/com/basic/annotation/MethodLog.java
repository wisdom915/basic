package com.basic.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface MethodLog {
    /**
     * 记录操作描述
     */
    String description() default "";

   /* *//**
     * 增删改的数据的类型
     *//*
    Class<?> clazz();*/
}
