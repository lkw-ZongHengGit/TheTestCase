package com.atguigu.gmall.user.retention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 自定义注解
* @Target说明了Annotation所修饰的对象范围,ElementType.METHOD说明修饰方法
*@Retention作用是定义被它所注解的注解保留多久，这里表明运行时
*  */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnInterception {
}
