package com.financialctl.financialinfo.infrastructure.adapters.config.bean;

import com.financialctl.financialinfo.application.ports.outbound.repositories.UserRepository;
import com.financialctl.financialinfo.domain.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfig {

    @Bean
    UserService userService(final UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
