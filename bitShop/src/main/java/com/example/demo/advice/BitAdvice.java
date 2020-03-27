package com.example.demo.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//HelloController의 모든 메소드들을 타겟으로 하는 어드바이스
@Aspect
@Component		//컴포넌트들을 자동으로 스캔	
public class BitAdvice {
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	public void cmethod() {
		
	}
	@Before	("cmethod()")
	public void before() {
		System.out.println("컨트롤러 동작전");
	}
}
