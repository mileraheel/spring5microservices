package com.emirates.training.webflux;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ApplicationTests {
	
	WebTestClient webClient;
	
	@Before
	public void setup() {
	webClient = WebTestClient.bindToServer()
	.baseUrl("http://localhost:8080").build();
	}

	@Test
	public void testWebFluxEndpoint() throws Exception {
		
		String responseMessage = 
				webClient.get().uri("/")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Greet.class).returnResult()
				.getResponseBody().getMessage();
		Assertions.assertThat(responseMessage.equals("Hello World!"));
	}
}	