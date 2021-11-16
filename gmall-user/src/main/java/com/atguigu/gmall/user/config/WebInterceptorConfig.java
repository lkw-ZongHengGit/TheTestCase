package com.atguigu.gmall.user.config;


import com.atguigu.gmall.user.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//configration注解一定要给上，因为要被扫描
//Configuration 自带 component
@Configuration
public class WebInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有路径
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/**/error")
                // swagger
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("**/swagger-resources/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/swagger-resources/configuration/**")
                // 静态资源
                .excludePathPatterns("/**/*.js")
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/*.mp3")
                .excludePathPatterns("/**/fonts/*")
                .excludePathPatterns("/**/*.png")
                .excludePathPatterns("/**/*.gif")
                .excludePathPatterns("/**/*.jpg")
                .excludePathPatterns("/**/*.jpeg")
                // actuator监控
                .excludePathPatterns("/actuator/**")
                // 船代云平台接口
                .excludePathPatterns("/unionCloudPlatform/**")
                // 定时任务调用，不进行用户认证
                .excludePathPatterns("/executeQuartz/**")
                .excludePathPatterns("/api/quartz/**")
                .excludePathPatterns("/openapi/**");;
    }
}
