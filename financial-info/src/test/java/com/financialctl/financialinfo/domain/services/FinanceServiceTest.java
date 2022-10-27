package com.financialctl.financialinfo.domain.services;

import com.financialctl.financialinfo.application.ports.outbound.repositories.FinanceRepository;
import com.financialctl.financialinfo.domain.models.Finance;
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
class FinanceServiceTest {

    @InjectMocks
    FinanceService financeService;

    @Mock
    FinanceRepository financeRepository;

    @Test
    @DisplayName("Should return finance when finance object is present")
    void shouldReturnFinanceWhenFinanceObjectIsPresent() {

        when(financeRepository.findById(anyLong()))
                .thenReturn(Optional.of(new Finance()));

        financeService.get(1L);

        verify(financeRepository, times(1))
                .findById(anyLong());
    }

    @Test
    @DisplayName("Should throw NotFoundException when finance does not exist")
    void shouldThrowNotFoundExceptionWhenFinanceDoesNotExist() {

        when(financeRepository.findById(anyLong()))
                .thenReturn(Optional.ofNullable(null));

        final NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> financeService.get(1L));

        assertThat(notFoundException.getMessage()).isEqualTo("Finance not found with id 1.");

        verify(financeRepository, times(1))
                .findById(anyLong());
    }
}
