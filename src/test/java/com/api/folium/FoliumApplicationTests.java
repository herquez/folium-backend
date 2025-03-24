package com.api.folium;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FoliumApplicationTests {
	@Autowired
	private DataSource dataSource;

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void testShouldUseH2Database() {
		assertThat(dataSource).isInstanceOf(HikariDataSource.class);
		String url = ((HikariDataSource) dataSource).getJdbcUrl();
		assertThat(url).contains("h2:mem:testdb");
	}

	@Test
	void shouldReturnNotFoundWithNonexistenceUrl() {
		ResponseEntity<String> response = restTemplate
				.getForEntity("/badUrl", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}
