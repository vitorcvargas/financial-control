package com.financialctl.financialalert.infrastructure.adapters.output.persistance;

import com.financialctl.financialalert.domain.models.Reminder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends MongoRepository<Reminder, String> {
}
