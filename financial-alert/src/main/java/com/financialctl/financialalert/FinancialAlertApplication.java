package com.financialctl.financialalert;

import com.financialctl.financialalert.domain.models.Reminder;
import com.financialctl.financialalert.domain.models.enums.DayPart;
import com.financialctl.financialalert.domain.models.enums.ReminderFrequency;
import com.financialctl.financialalert.infrastructure.adapters.output.persistance.ReminderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication(exclude={MongoAutoConfiguration.class})
@EnableMongoRepositories
public class FinancialAlertApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialAlertApplication.class, args);
		//TODO create alert model
		//TODO create alert sending structure (multiple alert sending ways)
		//TODO create REST
		//TODO create consumer
	}

	@Bean
	CommandLineRunner commandLineRunner(final ReminderRepository repository) {
		return args -> {
			final Reminder reminder = new Reminder(
					"vitor@gmail.com",
					"Pagar netflix",
					"Paga essa porra",
					ReminderFrequency.ONCE,
					DayPart.AFTERNOON,
					LocalDateTime.now()
			);

			repository.save(reminder);
		};
	}
}
