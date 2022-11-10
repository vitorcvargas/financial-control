package com.financialctl.financialalert.domain.models;

import com.financialctl.financialalert.domain.models.enums.DayPart;
import com.financialctl.financialalert.domain.models.enums.ReminderFrequency;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("reminders")
public class Reminder {

    @Id
    private String id;
    private String email;
    private String title;
    private String description;
    private ReminderFrequency frequency;
    private DayPart dayPart;
    private LocalDateTime currentReminderDate;
    private LocalDateTime nextReminderDate;
    private boolean enabled;

    public Reminder() {
    }


    public Reminder(final String email, final String title, final String description, final ReminderFrequency frequency, final DayPart dayPart, final LocalDateTime currentReminderDate) {
        this.email = email;
        this.title = title;
        this.description = description;
        this.frequency = frequency;
        this.dayPart = dayPart;
        this.currentReminderDate = currentReminderDate;
        enabled = true;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public ReminderFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(final ReminderFrequency frequency) {
        this.frequency = frequency;
    }

    public LocalDateTime getCurrentReminderDate() {
        return currentReminderDate;
    }

    public void setCurrentReminderDate(final LocalDateTime currentReminderDate) {
        this.currentReminderDate = currentReminderDate;
    }

    public LocalDateTime getNextReminderDate() {
        return nextReminderDate;
    }

    public void setNextReminderDate(final LocalDateTime nextReminderDate) {
        this.nextReminderDate = nextReminderDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public DayPart getDayPart() {
        return dayPart;
    }

    public void setDayPart(final DayPart dayPart) {
        this.dayPart = dayPart;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", frequency=" + frequency +
                ", dayPart=" + dayPart +
                ", currentReminderDate=" + currentReminderDate +
                ", nextReminderDate=" + nextReminderDate +
                ", enabled=" + enabled +
                '}';
    }
}
