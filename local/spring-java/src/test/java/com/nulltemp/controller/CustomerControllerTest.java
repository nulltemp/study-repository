package com.nulltemp.controller;

import com.nulltemp.request.CreateCustomerRequest;
import com.nulltemp.response.CustomerResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate testRestTemplate;

	@DisplayName("DBロールバック確認テスト")
	@Nested
	@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
	class Save {
		@Test
		public void case1() {
			String url = UriComponentsBuilder.fromHttpUrl("http://localhost").port(port)
					.pathSegment("api", "customers").toUriString();
			CreateCustomerRequest request = new CreateCustomerRequest("firstName1", "lastName1");
			testRestTemplate.postForEntity(url, request, CustomerResponse.class);

			RequestEntity<Void> requestEntity = RequestEntity.get(url).build();
			ResponseEntity<List<CustomerResponse>> responseEntity = testRestTemplate.exchange(requestEntity,
					new ParameterizedTypeReference<>() {});
			System.out.println(responseEntity.getBody());
			Assertions.assertNotNull(responseEntity.getBody());
			Assertions.assertEquals(1, responseEntity.getBody().size());
		}

		@Test
		public void case2() {
			String url = UriComponentsBuilder.fromHttpUrl("http://localhost").port(port)
					.pathSegment("api", "customers").toUriString();
			CreateCustomerRequest request = new CreateCustomerRequest("firstName2", "lastName2");
			testRestTemplate.postForEntity(url, request, CustomerResponse.class);

			RequestEntity<Void> requestEntity = RequestEntity.get(url).build();
			ResponseEntity<List<CustomerResponse>> responseEntity = testRestTemplate.exchange(requestEntity,
					new ParameterizedTypeReference<>() {});
			System.out.println(responseEntity.getBody());
			Assertions.assertNotNull(responseEntity.getBody());
			Assertions.assertEquals(1, responseEntity.getBody().size());
		}
	}
}
