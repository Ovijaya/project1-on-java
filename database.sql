CREATE TABLE stations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    station_name VARCHAR(100),
    location VARCHAR(100),
    power_usage FLOAT,
    status VARCHAR(50)
);