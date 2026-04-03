CREATE TABLE sensor_readings (
    id BIGSERIAL PRIMARY KEY,
    sensor_id VARCHAR(100) NOT NULL,
    soil_moisture DECIMAL(5,2) NOT NULL,
    temperature DECIMAL(5,2),
    humidity DECIMAL(5,2),
    reading_time TIMESTAMP NOT NULL
);
