package com.springbootdev.amazon.s3.example.aws;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootdev.amazon.s3.example.aws.config.CustomeUserDetailsService;
import com.springbootdev.amazon.s3.example.aws.config.UserDetails;

@EnableAsync
@SpringBootApplication
public class SpringBootAmazonS3ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmazonS3ExampleApplication.class, args);
    }
    
    @Bean
	CommandLineRunner runner(CustomeUserDetailsService userService) {
		return args -> {
			// read json and write to db
			System.out.println("Users Saved started .....");
			ObjectMapper mapper = new ObjectMapper();
			//TypeReference<List<UserDetails>> typeReference = new TypeReference<List<UserDetails>>(){};
			TypeReference<UserDetails> typeReference = new TypeReference<UserDetails>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/Task-def.json");
			try {
				//List<UserDetails> users = mapper.readValue(inputStream,typeReference);
				UserDetails users = mapper.readValue(inputStream,typeReference);
				
				userService.loadUser(Arrays.asList(users));
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
}
