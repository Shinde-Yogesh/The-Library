package com.books.login_module;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class Login_validation {
	
	//Method give the parameter like (* controller class package path.controller class name. method who want to access)
	@Before("execution(* com.books.controller.Librarian_Controller.get_users())")
	public void check_Athorization()
	{
		System.out.println("User is valid to loging .. "+ LocalDateTime.now());
	}
	
	
	//Method give the parameter like (* controller class package path.controller class name. method who want to access)
		@After("execution(* com.books.controller.Librarian_Controller.get_users())")
		public void check_Athorization_After()
		{
			System.out.println("User is valid to logout  ..");
		}
		
	
}
