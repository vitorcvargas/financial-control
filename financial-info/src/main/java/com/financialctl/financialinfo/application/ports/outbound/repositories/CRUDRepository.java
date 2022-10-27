package com.financialctl.financialinfo.application.ports.outbound.repositories;

import java.util.Optional;

public interface CRUDRepository<T, ID> {

    T save(final T object);

    Optional<T> findById(final ID id);

    void delete(final ID id);
}
