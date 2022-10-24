package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.OperationRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

    @InjectMocks
    OperationService operationService;

    @Mock
    OperationRepository operationRepository;

    @Mock
    FinanceServicePort financeService;

    @Test
    @DisplayName("Should save operation when finance exists")
    void shouldSaveOperationWhenFinanceExists() {

        Operation operation = new Operation();
        Finance finance = new Finance();
        finance.setId(1L);
        operation.setFinance(finance);


        when(financeService.get(anyLong()))
                .thenReturn(new Finance());
        when(operationRepository.save(any(Operation.class)))
                .thenReturn(new Operation());

        operationService.save(operation);

        verify(operationRepository, times(1))
                .save(any(Operation.class));
        verify(financeService, times(1))
                .get(anyLong());
    }

    @Test
    @DisplayName("Should return operation when operation object is present")
    void shouldReturnFinanceWhenFinanceObjectIsPresent() {

        when(operationRepository.findById(anyLong()))
                .thenReturn(Optional.of(new Operation()));

        operationService.get(1L);

        verify(operationRepository, times(1))
                .findById(anyLong());
    }
}
