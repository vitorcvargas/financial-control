package com.financialctl.financialinfo.utils.integration.containers;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class MySqlContainer {

    private static final String IMAGE_VERSION = "mysql:5.7";

    @Container
    private static final MySQLContainer container = new MySQLContainer(IMAGE_VERSION);

    public static MySQLContainer getInstance() {
        return container;
    }
}
