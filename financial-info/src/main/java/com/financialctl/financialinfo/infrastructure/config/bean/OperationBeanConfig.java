package com.financialctl.financialinfo.infrastructure.config.bean;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.OperationRepository;
import com.financialctl.financialinfo.domain.services.OperationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationBeanConfig {

    @Bean
    OperationService operationService(final OperationRepository operationRepository, final FinanceServicePort financeService) {
        return new OperationService(operationRepository, financeService);
    }
}
