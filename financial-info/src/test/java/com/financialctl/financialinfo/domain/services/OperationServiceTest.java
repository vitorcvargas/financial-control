package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.inbound.FinanceServicePort;
import com.financialctl.financialinfo.application.ports.outbound.repositories.OperationRepository;
import com.financialctl.financialinfo.domain.models.Finance;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    @DisplayName("Should update operation when operation exists")
    void shouldUpdateOperationWhenOperationExists() {

        Operation operation = new Operation();
        operation.setId(1L);

        when(operationRepository.findById(anyLong()))
                .thenReturn(Optional.of(new Operation()));
        when(operationRepository.save(any(Operation.class)))
                .thenReturn(new Operation());

        operationService.update(operation);

        verify(operationRepository, times(1))
                .save(any(Operation.class));
    }

    @Test
    @DisplayName("Should throw NotFoundException when operation does not exist in update flow")
    void shouldThrowNotFoundExceptionWhenOperationDoesNotExistInUpdateFlow() {
        final Operation operation = new Operation();
        operation.setId(1L);

        when(operationRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(null));

        final NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> operationService.update(operation));

        assertThat(notFoundException.getMessage()).isEqualTo("Operation not found with id 1.");

        verify(operationRepository, times(0))
                .save(any(Operation.class));
    }

    @Test
    @DisplayName("Should delete operation when operation exists")
    void shouldDeleteOperationWhenOperationExists() {

        when(operationRepository.findById(anyLong()))
                .thenReturn(Optional.of(new Operation()));

        operationService.delete(1L);

        verify(operationRepository, times(1))
                .delete(anyLong());
    }

    @Test
    @DisplayName("Should throw NotFoundException when operation does not exist in delete flow")
    void shouldThrowNotFoundExceptionWhenOperationDoesNotExistInDeleteFlow() {

        when(operationRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(null));

        final NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> operationService.delete(1L));

        assertThat(notFoundException.getMessage()).isEqualTo("Operation not found with id 1.");

        verify(operationRepository, times(0))
                .delete(anyLong());
    }

    @Test
    @DisplayName("Should return operation when operation is present")
    void shouldReturnOperationWhenOperationIsPresent() {

        when(operationRepository.findById(anyLong()))
                .thenReturn(Optional.of(new Operation()));

        operationService.get(1L);

        verify(operationRepository, times(1))
                .findById(anyLong());
    }

    @Test
    @DisplayName("Should throw NotFoundException when operation does not exist")
    void shouldThrowNotFoundExceptionWhenOperationDoesNotExist() {

        when(operationRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(null));

        final NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> operationService.get(1L));

        assertThat(notFoundException.getMessage()).isEqualTo("Operation not found with id 1.");

        verify(operationRepository, times(1))
                .findById(anyLong());
    }
}
