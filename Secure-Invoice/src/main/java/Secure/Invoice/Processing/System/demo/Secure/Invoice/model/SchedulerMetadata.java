package Secure.Invoice.Processing.System.demo.Secure.Invoice.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scheduler_metadata")
public class SchedulerMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime lastRunTime;

    // Default Constructor
    public SchedulerMetadata() {
    }

    // Parameterized Constructor
    public SchedulerMetadata(Long id, LocalDateTime lastRunTime) {
        this.id = id;
        this.lastRunTime = lastRunTime;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLastRunTime() {
        return lastRunTime;
    }

    public void setLastRunTime(LocalDateTime lastRunTime) {
        this.lastRunTime = lastRunTime;
    }
}