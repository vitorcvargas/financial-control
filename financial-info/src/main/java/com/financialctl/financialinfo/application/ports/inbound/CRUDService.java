package com.financialctl.financialinfo.application.ports.inbound;

public interface CRUDService<T, ID> {

    T save(final T obj);

    T get(final ID id);
}
