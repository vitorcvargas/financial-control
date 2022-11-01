package com.financialctl.financialinfo.domain.models;

import com.financialctl.financialinfo.domain.models.enums.OperationEntry;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

public class Finance {

    private Long id;
    private User user;
    private List<Operation> operations;

    public List<Operation> filterOperations(final OperationFilter filter) {
        final Window window = filter.getWindow();

        return operations.stream()
                .filter(operation -> filterOperationDate(operation.getDate(), window))
                .filter(operation -> filterOperationAmount(operation.getAmount(), window))
                .filter(operation -> filterDescriptions(operation.getDescription(), filter.getDescriptions()))
                .filter(operation -> filterOperationEntries(operation.getOperationEntryType(), filter.getOperationEntryTypes()))
                .sorted(Comparator.comparing(Operation::getDate).reversed())
                .collect(Collectors.toList());
    }

    private boolean filterOperationEntries(final OperationEntry operationEntryType, final List<OperationEntry> operationEntriesLookup) {
        return isEmpty(operationEntriesLookup) || operationEntriesLookup.contains(operationEntryType);
    }

    private boolean filterDescriptions(final String description, final List<String> descriptionsLookup) {
        return isEmpty(descriptionsLookup) || descriptionsLookup.stream()
                .anyMatch(lookup -> description.toLowerCase().matches(format(".*%s.*", lookup.toLowerCase())));
    }

    private boolean filterOperationAmount(final Double operationAmount, final Window window) {
        return (isNull(window.getFromAmount()) || isNull(window.getToAmount())) ||
                (operationAmount >= window.getFromAmount() && operationAmount <= window.getToAmount());
    }

    private boolean filterOperationDate(final ZonedDateTime operationDate, final Window window) {
        return (operationDate.isEqual(window.getFromDate()) || operationDate.isAfter(window.getFromDate())) &&
                (operationDate.isEqual(window.getToDate()) || operationDate.isBefore(window.getToDate()));
    }

    public Finance() {
    }

    public Finance(final User user, final List<Operation> operations) {
        this.user = user;
        this.operations = operations;
    }

    public Finance(final Long id, final User user, final List<Operation> operations) {
        this.id = id;
        this.user = user;
        this.operations = operations;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(final List<Operation> operations) {
        this.operations = operations;
    }


    @Override
    public String toString() {
        return "Finance{" +
                "id=" + id +
                ", user=" + user +
                ", operations=" + operations +
                '}';
    }
}
