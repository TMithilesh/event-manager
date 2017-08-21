package dxl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class EventManagerApp 
{

	public static void main(String[] args) 
	{
		// it will scan all the annotation, start tomcat.
		SpringApplication.run(EventManagerApp.class, args);
	}

}


//it is same as @EnableAutoConfigration, @Configration