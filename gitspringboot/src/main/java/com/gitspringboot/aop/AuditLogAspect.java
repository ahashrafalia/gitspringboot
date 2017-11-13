package com.gitspringboot.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLogAspect {


	@Before("@annotation(AuditLog)")
	public void before(JoinPoint joinPoint) {
	//@Around("@annotation(AuditLog)")
	//public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		
		Method method = getCurrentMethod(joinPoint);
		System.out.println("I am calling Audit AOP="+method.getName());
		Object[] parameters = joinPoint.getArgs();



		for (int i = 0; i < parameters.length; i++) {
			Object parameterValue = parameters[i];
			System.out.println("parameterValue="+parameterValue);
		}
		//return joinPoint.proceed();

	}

	private Method getCurrentMethod(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		return signature.getMethod();
	}
}
