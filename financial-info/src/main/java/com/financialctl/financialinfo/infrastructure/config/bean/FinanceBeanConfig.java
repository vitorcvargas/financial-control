package com.financialctl.financialinfo.infrastructure.config.bean;

import com.financialctl.financialinfo.application.ports.outbound.repositories.FinanceRepository;
import com.financialctl.financialinfo.domain.services.FinanceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinanceBeanConfig {

    @Bean
    FinanceService financeService(final FinanceRepository financeRepository) {
        return new FinanceService(financeRepository);
    }
}
