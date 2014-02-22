package uk.co.eelpieconsulting.postcodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@ComponentScan
@Configuration
@EnableScheduling
public class Main {
	    
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Main.class, args);
    }
    
}
