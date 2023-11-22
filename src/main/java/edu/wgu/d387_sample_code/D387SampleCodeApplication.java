package edu.wgu.d387_sample_code;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class D387SampleCodeApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(D387SampleCodeApplication.class, args);
    }

}
