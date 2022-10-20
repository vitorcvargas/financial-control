package com.financialctl.financialinfo.config.integration;

import com.financialctl.financialinfo.config.integration.containers.MySqlContainer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@DirtiesContext
public class IntegrationTestBase {

    public static MySQLContainer mySqlContainer = MySqlContainer.getInstance();

    static {
        mySqlContainer.start();
    }

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySqlContainer::getJdbcUrl);
    }
}
