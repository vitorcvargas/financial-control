package com.financialctl.financialinfo.application.ports.inbound;

public interface CRUDService<O, T> {

    T save(O obj);
}
