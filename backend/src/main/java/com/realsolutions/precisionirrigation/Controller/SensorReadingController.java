package com.realsolutions.precisionirrigation.Controller;



import com.realsolutions.precisionirrigation.Entity.SensorReading;
import com.realsolutions.precisionirrigation.Service.SensorReadingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
public class SensorReadingController {

    private final SensorReadingService sensorReadingService;

    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    @PostMapping("/readings")
    @ResponseStatus(HttpStatus.CREATED)
    public SensorReading createReading(@RequestBody SensorReading reading) {
        return sensorReadingService.saveReading(reading);
    }

    @GetMapping("/latest")
    public SensorReading getLatestReading() {
        return sensorReadingService.getLatestReading();
    }
}
