package com.teleradms.common.lib.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.teleradms..service..*(..))")
    public void serviceLayer() {}

    @Around("serviceLayer()")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        CodeSignature signature = (CodeSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        String[] paramNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        StringBuilder inputLog = new StringBuilder("➡️ Started: " + methodName + " | Args: [");
        for (int i = 0; i < args.length; i++) {
            inputLog.append(paramNames[i]).append("=").append(args[i]);
            if (i < args.length - 1) inputLog.append(", ");
        }
        inputLog.append("]");
        log.info(inputLog.toString());

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable ex) {
            stopWatch.stop();
            log.error("❌ Exception in {}: {} | Duration: {} ms", methodName, ex.getMessage(), stopWatch.getTotalTimeMillis(), ex);
            throw ex;
        }

        stopWatch.stop();
        log.info("✅ Finished: {} | Duration: {} ms | Result: {}", methodName, stopWatch.getTotalTimeMillis(), result);
        return result;
    }
}
