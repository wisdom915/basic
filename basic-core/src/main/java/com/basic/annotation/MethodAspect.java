package com.basic.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class MethodAspect {

    //声明个切面，切哪呢？
        @Pointcut("@annotation(com.basic.annotation.MethodLog)") //对加注解的方法进行切入
    //@Pointcut("execution(* com.basic.controller..*.*(..))") //对指定包下所有方法进行切入
    public void pointcut() {}//切入点签名

    /**
     * 前置通知
     */
    @Before("pointcut()") //两种引入切点的方式 1.在注解中引入
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("before method   start ...");

        System.out.println("before method   end ...");
    }

    /**
     * 环绕通知
     */
    @Around("@annotation(methodLog)") //2.通过参数引入
    public void beforeMethod(ProceedingJoinPoint joinPoint, MethodLog methodLog) {
        System.out.println("Around method   start ...");

        System.out.println("Around method   end ...");
    }

    /**
     * 获取方法的中文备注____用于记录用户的操作日志描述
     */
    private MethodLog getMethodRemark(JoinPoint joinPoint) throws Exception {
        //返回目标对象
        Object target = joinPoint.getTarget();
        String targetName = target.getClass().getName();
        //返回当前连接点签名
        String methodName = joinPoint.getSignature().getName();
        //获得参数列表
        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        //这个怎么这么low呢。
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    MethodLog methodCache = m.getAnnotation(MethodLog.class);
                    if (methodCache != null && !("").equals(methodCache.description())) {
                        return methodCache;
                    }
                    break;
                }
            }
        }
        return null;
    }
}
