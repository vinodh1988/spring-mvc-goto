package com.utils;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Person;

@Aspect
@Component
public class TestAspect {
	@Autowired
	SessionVariables session;
	@Autowired
	ApplicationVariables application;

	private Logger logger = Logger.getLogger(TestAspect.class);
    @Pointcut("execution(* com.control.FirstController.storePerson(..))")
	public void mycut(){
		
	}
    
 
    @Pointcut("execution(* com.control.FirstController.*(..))")
	public void scope(){
		
	}
    
    @Before("scope()")
    public void process(){
    	logger.info("Scope Running...");
    	session.setAppRequests();
    	application.setAppRequests();
    }
    
    @AfterReturning(pointcut = "mycut()", returning = "retVal")
    public void afterReturningAdvice(Object retVal){
     //  System.out.println("Returning:" + retVal.toString() );
       System.out.println("Change is change....");
       String ret=(String)retVal;
       if(ret==null)
    	   return;
       if(ret.equals("form"))
         logger.info("Request processed but validation failed....");
       
         else if(ret.equalsIgnoreCase("home"))
        	 logger.info("Request processed and data stored");
         else
        	 logger.info("Validation success but insertion failed");
        	 
    }
    
    @Around("mycut()")
    public String aroundAdvice(ProceedingJoinPoint jp){
    	System.out.println("Running");
    	 String test=null; 
    	 try{
    		Object []o=jp.getArgs();
    		Person p=(Person)o[0];
    		System.out.println(p.getName()+" is the name of the person...!!!");
    		
    		for(Object x:o)
    			System.out.println(x);
    		
    		  test =(String)	jp.proceed();
		} 
    	 catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("Continuing");
    	return test;
    }

}
