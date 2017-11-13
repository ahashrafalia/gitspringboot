package com.gitspringboot.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gitspringboot.model.AuditLog;
import com.gitspringboot.service.AuditLogService;

@Aspect
@Component
public class AuditLogAspect {

	@Autowired
	AuditLogService auditLogSerive;

	@Before("@annotation(AuditLogA)")
	public void before(JoinPoint joinPoint) {
	//@Around("@annotation(AuditLog)")
	//public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		
		Method method = getCurrentMethod(joinPoint);
		System.out.println("I am calling Audit AOP="+method.getName());
		Object[] parameters = joinPoint.getArgs();


		Object parameterValue=null;
		for (int i = 0; i < parameters.length; i++) {
			 parameterValue = parameters[i];
			System.out.println("parameterValue="+parameterValue);
		}
		AuditLog auditEntity=new AuditLog();
		
		auditEntity.setCurrentValue((String)parameterValue);
		auditEntity.setEventName(method.getName());
		auditEntity.setFieldName(null);
		auditEntity.setModifiedBy("ADMIN");
		auditEntity.setModifiedOn(new Date());
		auditLogSerive.save(auditEntity);
		//return joinPoint.proceed();

	}

	private Method getCurrentMethod(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		return signature.getMethod();
	}
}
