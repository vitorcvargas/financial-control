package com.financialctl.financialinfo.infrastructure.config.bean;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.FinanceRepository;
import com.financialctl.financialinfo.application.ports.outbound.repositories.OperationRepository;
import com.financialctl.financialinfo.application.ports.outbound.repositories.UserRepository;
import com.financialctl.financialinfo.domain.services.FinanceService;
import com.financialctl.financialinfo.domain.services.OperationService;
import com.financialctl.financialinfo.domain.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    FinanceService financeService(final FinanceRepository financeRepository) {
        return new FinanceService(financeRepository);
    }

    @Bean
    OperationService operationService(final OperationRepository operationRepository, final FinanceServicePort financeService) {
        return new OperationService(operationRepository, financeService);
    }

    @Bean
    UserService userService(final UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
