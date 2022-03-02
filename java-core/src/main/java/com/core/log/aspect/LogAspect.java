package com.core.log.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志切面
 */
@Component
@Aspect // aop切面
public class LogAspect {
    //现在想在实现类中的每个方法执行前、后、以及是否发生异常等信息打印出来，需要把日志信息抽取出来，写到对应的切面的类中 LogAspect.java 中
    //要想把一个类变成切面类，需要两步，
    //① 在类上使用 @Component 注解 把切面类加入到IOC容器中
    //② 在类上使用 @Aspect 注解 使之成为切面类

    // 切入点
    @Pointcut(value = "@annotation(Log)")
    public void Pointcut() {
    }

    /**
     * 环绕通知目标方法执行前后都执行
     *
     * @param jp  jp
     * @param log log
     * @return 执行结果
     */
    @Around(value = "Pointcut() && @annotation(log)")
    public Object interceptor(ProceedingJoinPoint jp, Log log) {
        System.out.println("---------------------------");
        String methodName = jp.getSignature().getName();
        Object result = null;
        try {
            System.out.println("【环绕通知中的--->前置通知】：the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
            //执行目标方法
            result = jp.proceed();
            System.out.println("【环绕通知中的--->返回通知】：the method 【" + methodName + "】 ends with " + result);
        } catch (Throwable e) {
            System.out.println("【环绕通知中的--->异常通知】：the method 【" + methodName + "】 occurs exception " + e);
        }

        System.out.println("【环绕通知中的--->后置通知】：-----------------end.----------------------");
        return result;
    }
}


