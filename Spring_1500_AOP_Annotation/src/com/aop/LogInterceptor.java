package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	
//	@Pointcut("execution(public * com.dao..*.*(..))")
//	public void myMethod(){};

	@Pointcut("execution(public * com.service..*.add(..))")
	public void myMethod(){};
	
	@Before("myMethod()")
	public void before3(){
		System.out.println("method before");
	}
	
//	@AfterReturning("myMethod()")
//	public void afterReturning() {
//		// TODO Auto-generated method stub
//		System.out.println("method after returning");
//	}

//	@AfterThrowing("myMethod()")
//	public void afterReturning() {
//		// TODO Auto-generated method stub
//		System.out.println("method after throwing");
//	}
	
	@Around("myMethod()")
	public void doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
		
		System.out.println("method around start");
		pjp.proceed();
		System.out.println("method around end");
		
	}
	
	
//	@Before("execution(public void com.dao.impl.UserDAOImpl.save(com.model.User))")
//	public void before() {
//		System.out.println("method start");
//	}
	
//	@Before("execution(public * com.dao..*.*(..))")
//	public void before1() {
//		System.out.println("method start");
//	}

	
	
//	@After("execution(public void com.dao.impl.UserDAOImpl.save(com.model.User))")
//	public void after() {
//		System.out.println("method end");
//	}

//	@After("execution(* com.dao.impl.*.*(*))")
//	public void after1() {
//		System.out.println("method after1 end");
//	}
	
	
/*
	the execution of any public method:
	execution(public * *(..))
	
	the execution of any method with a name beginning with "set":
	execution(* set*(..))
	
	the execution of any method defined by the AccountService interface:
	execution(* com.xyz.service.AccountService.*(..))
	
	the execution of any method defined in the service package:
	execution(* com.xyz.service.*.*(..))
	
	the execution of any method defined in the service package or a sub-package:
	execution(* com.xyz.service..*.*(..))
	
*/
	
/*
	@AfterThrowing("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doRecoveryActions() {
	  // ...throw todo something
	}
	
	@Around("com.xyz.myapp.SystemArchitecture.businessService()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		// start stopwatch
		Object retVal = pjp.proceed();
		// stop stopwatch
		return retVal;
	}*/
	
	
}
