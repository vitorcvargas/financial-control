package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories;

import com.financialctl.financialinfo.application.ports.outbound.repositories.OperationRepository;
import com.financialctl.financialinfo.domain.models.Operation;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.OperationDB;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers.CycleAvoidingMappingContext;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers.OperationDBMapper;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.repositories.jpa.OperationRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OperationRepositoryAdapter implements OperationRepository {

    private final OperationRepositoryJPA repository;

    public OperationRepositoryAdapter(final OperationRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public Operation save(final Operation operation) {
        final OperationDB newOperationDB = repository.save(operationToOperationDB(operation));
        return operationDBToOperation(newOperationDB);
    }

    @Override
    public Optional<Operation> findById(final Long id) {
        final Optional<OperationDB> optional = repository.findById(id);

        return Optional.ofNullable(operationDBToOperation(optional.orElse(null)));
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    private Operation operationDBToOperation(final OperationDB operationDB) {
        return OperationDBMapper.INSTANCE.operationDBToOperation(operationDB, new CycleAvoidingMappingContext());
    }

    private OperationDB operationToOperationDB(final Operation operation) {
        return OperationDBMapper.INSTANCE.operationToOperationDB(operation, new CycleAvoidingMappingContext());
    }
}
