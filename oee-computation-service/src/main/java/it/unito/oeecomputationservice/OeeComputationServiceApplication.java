package it.unito.oeecomputationservice;

import it.unito.oeecomputationservice.events.GreetingStreams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingStreams.class)
@SpringBootApplication
public class OeeComputationServiceApplication
{
	public static void main(String[] args) {
		SpringApplication.run(OeeComputationServiceApplication.class, args);
	}

}

