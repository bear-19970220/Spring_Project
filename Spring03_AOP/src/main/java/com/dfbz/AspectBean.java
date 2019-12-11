package com.dfbz;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/11 18:37
 */
@Component
public class AspectBean {

    public void beforeMethod() {
        System.out.println("前置通知...");
    }

    public void afterReturningMethod() {
        System.out.println("后置通知...");
    }

    public void throwingError() throws Exception {
        System.out.println("出错啦，笨蛋！");
    }

    public void after() {
        System.out.println("最终通知");
        System.out.println();
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Object result = joinPoint.proceed();
        System.out.println("环绕后");
        return result;
    }

}
