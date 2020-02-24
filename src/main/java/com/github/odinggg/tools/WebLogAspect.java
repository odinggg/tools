package com.github.odinggg.tools;

import com.github.odinggg.tools.util.JacksonConvertUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述:
 * 统一处理请求日志
 *
 * @outhor admin
 * @create 2018-03-30 15:10
 */
@Component
@Aspect
public class WebLogAspect {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.github.odinggg.tools.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature()
                .getName());
        Object[] args = joinPoint.getArgs();
        List<Object> collect = Stream.of(args)
                .filter(o -> !(o instanceof HttpServletRequest || o instanceof HttpServletResponse))
                .collect(Collectors.toList());
        log.info("ARGS:" + JacksonConvertUtil.objectToJson(collect));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        log.info("RESPONSE : " + JacksonConvertUtil.objectToJson(ret));
//        log.info("RESPONSE_TIME : " + new Date().toLocaleString());
    }
}
