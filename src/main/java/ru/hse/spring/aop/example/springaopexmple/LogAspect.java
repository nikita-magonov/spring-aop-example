package ru.hse.spring.aop.example.springaopexmple;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

    @Pointcut("@annotation(Log)")
    public void annotatedWithLog() { }

    @Around("annotatedWithLog()")
    public Object aroundAnnotatedWithLog(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        System.out.println("[" + startTime + "] - " + "About to call " + pjp.getTarget().getClass().getName() + "#" + pjp.getSignature().getName() + "...");

        Object returnValue = pjp.proceed();

        long finishTime = System.currentTimeMillis();

        System.out.println("[" + finishTime + "] - " + "Call " + pjp.getTarget().getClass().getName() + "#" + pjp.getSignature().getName() + "finished.");

        return returnValue;
    }
}
