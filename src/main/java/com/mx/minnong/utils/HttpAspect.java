package com.mx.minnong.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.mx.minnong.controller..*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("[URL]:{}\t\t[IP]:{}\t\t[METHOD]:{}\t\t[PARAM]:{}\t\t[CLASS_METHOD]:{}",request.getRequestURI(),IpUtil.getIpAddr(request),request.getMethod(),joinPoint.getArgs(),joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }

    @Pointcut("execution(public * com.mx.minnong.controller.ProduceController.findById(..))")
    public void addV(){

    }
    @After("addV()")
    public void doAfter(JoinPoint joinPoint){

    }

}
