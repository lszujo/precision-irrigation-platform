package com.realsolutions.precisionirrigation.Entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_readings")
@Getter
@Setter
@NoArgsConstructor

public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "soil_moisture", nullable = false)
    private BigDecimal soilMoisture;

    @Column(name = "temperature")
    private BigDecimal temperature;

    @Column(name = "humidity")
    private BigDecimal humidity;

    @Column(name = "reading_time", nullable = false)
    private LocalDateTime readingTime;

    @Column(name = "sensor_id", nullable = false)
    private String sensorId;

    // Constructor WITHOUT id
    public SensorReading(BigDecimal soilMoisture, BigDecimal temperature, BigDecimal humidity, LocalDateTime readingTime) {
        this.soilMoisture = soilMoisture;
        this.temperature = temperature;
        this.humidity = humidity;
        this.readingTime = readingTime;
    }

    // Optional: auto-set timestamp
    @PrePersist
    public void prePersist() {
        if (readingTime == null) {
            readingTime = LocalDateTime.now();
        }
    }
}