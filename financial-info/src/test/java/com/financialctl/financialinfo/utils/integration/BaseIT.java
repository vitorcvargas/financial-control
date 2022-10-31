package com.financialctl.financialinfo.utils.integration;

import com.financialctl.financialinfo.utils.integration.containers.MySqlContainer;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.RestAssured.port;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@DirtiesContext
public class BaseIT {

    @LocalServerPort
    private Integer randomPort;

    public static MySQLContainer mySqlContainer = MySqlContainer.getInstance();

    @BeforeEach
    void setPort() {
        port = randomPort;
    }

    static {
        mySqlContainer.start();
    }

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySqlContainer::getJdbcUrl);
    }
}
