package br.com.fourdchallenge.backofficeapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class FourdChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(br.com.fourdchallenge.backofficeapi.FourdChallengeApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
