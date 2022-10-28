package com.financialctl.financialinfo.utils.integration;

import com.financialctl.financialinfo.utils.integration.containers.MySqlContainer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@DirtiesContext
public class IntegrationTestBase {

    @LocalServerPort
    private Integer randomPort;

    public static MySQLContainer mySqlContainer = MySqlContainer.getInstance();

    static {
        mySqlContainer.start();
    }

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySqlContainer::getJdbcUrl);
    }

    public Integer getRandomPort() {
        return randomPort;
    }
}
