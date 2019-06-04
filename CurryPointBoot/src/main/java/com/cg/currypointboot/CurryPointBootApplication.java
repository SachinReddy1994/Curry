 /**
		 * @author syerrana 
		 *Indicates a configuration class that declares one or more 
		 @Bean methods and also triggers auto-configuration and component scanning
		 * */
package com.cg.currypointboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg.currypointboot")
public class CurryPointBootApplication {

	public static void main(String[] args) {
		/**
		 * @author syerrana
		 * Class that can be used to bootstrap and launch a Spring application from a Java main method.
		 */
		SpringApplication.run(CurryPointBootApplication.class, args);
		System.out.println("Welcome to Spring Boot");
	}

}
