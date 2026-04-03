package com.realsolutions.precisionirrigation.Repository;

import com.realsolutions.precisionirrigation.Entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {
    Optional<SensorReading> findTopByOrderByReadingTimeDesc();
}
