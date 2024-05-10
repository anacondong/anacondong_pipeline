package com.example.demo;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Value("${demo.application.string}")
	private String s;

	@Value("${demo.application.int}")
	private String i;

	@Value("${demo.application.boolean}")
	private String b;

	@Value("${application.name:nope}")
	private String configMapAppName;

	@Value("${application.version:nope}")
	private String configMapAppVersion;

	@Value("${myapp.greeting:nope}")
	private String configMapGreeting;

	@Value("${myconfigmap.hello:nope}")
	private String configMapHello;

	@GetMapping("/")
	public String demo() {

		String responseString = "Hello This is Demo ";
		responseString += "<br/>  ====================================";
		responseString += "<br/> ***** API properties *****";
		responseString += "<br/>  application properties string: "+ s;
		responseString += "<br/>  application properties int: "+ i;
		responseString += "<br/>  application properties boolean: "+ b;
		responseString += "<br/>  ***** ConfigMap properties *****";
		responseString += "<br/>  application properties from configMap appName: "+ configMapAppName;
		responseString += "<br/>  application properties from configMap appVersion: "+ configMapAppVersion;
		responseString += "<br/>  configMap Mapping Value greeting: "+ configMapGreeting;
		responseString += "<br/>  configMap Mapping Value hello: "+ configMapHello;
		responseString += "<br/> Ken ken";
		responseString += "<br/>  ====================================";
		return responseString;

	}
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!";
	}

	@GetMapping("/user")
	public List<User> getUser() {
		return Arrays.asList(new User("q", "sq"), new User("d", "sd"));
	}

	@GetMapping("/docker-user")
	public List<User> getDockerUser() {
		RestTemplate restTemplate = new RestTemplate();

		// finding your ip to url
		ResponseEntity<List<User>> response =
				restTemplate.exchange("http://111.11.111.1:8081/user",
						HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
						});
		return response.getBody();
	}
}
