package aop.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 观众类。
 */
@Aspect
@Component
public class Audience {

    @Pointcut("execution(* aop.around.*.perform(..))")
    public void performance() {}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("把手机调成静音");
            System.out.println("大家请坐");
            jp.proceed();
            System.out.println("大家鼓掌吧");
        } catch (Throwable e) {
            System.out.println("表演砸了，退钱退钱");
        }
    }
}
