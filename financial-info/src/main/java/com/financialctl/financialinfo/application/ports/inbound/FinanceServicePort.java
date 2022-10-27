package com.financialctl.financialinfo.application.ports.inbound;

import com.financialctl.financialinfo.domain.models.Finance;

public interface FinanceServicePort {
    Finance get(final Long id);
}
