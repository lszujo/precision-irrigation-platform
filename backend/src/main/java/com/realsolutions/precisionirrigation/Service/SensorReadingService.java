package com.realsolutions.precisionirrigation.Service;

import com.realsolutions.precisionirrigation.Entity.SensorReading;
import com.realsolutions.precisionirrigation.Repository.SensorReadingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SensorReadingService {

    private final SensorReadingRepository sensorReadingRepository;

    public SensorReadingService(SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    public SensorReading saveReading(SensorReading reading) {
        if (reading.getReadingTime() == null) {
            reading.setReadingTime(LocalDateTime.now());
        }
        return sensorReadingRepository.save(reading);
    }

    public SensorReading getLatestReading() {
        return sensorReadingRepository.findTopByOrderByReadingTimeDesc()
                .orElseThrow(() -> new RuntimeException("No sensor readings found"));
    }
}
