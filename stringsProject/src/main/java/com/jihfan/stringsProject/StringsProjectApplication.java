package com.jihfan.stringsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class StringsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsProjectApplication.class, args);
	}
	
	// 1. Annotation
    @RequestMapping("/")
    // 3. Method that maps to the request route above
    public String home() { // 3
            return "Hello client! How are you?";
    }
    
    @RequestMapping("/random")
    public String random() {
    	return "Spring Boot is Great! Spring strings rings blings";
    }
    
    
}
