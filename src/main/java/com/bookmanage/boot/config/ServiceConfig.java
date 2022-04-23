package com.bookmanage.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
//@Component
@Data
@ConfigurationProperties(prefix = "services")
public class ServiceConfig {
    private String ipAddress;
    private int port;
    private long timeout;
    //java提供的时间单位类，统一时间的单位
    @DurationUnit(ChronoUnit.SECONDS)
    Duration serviceTimeout;
    //统一数据单位
    @DataSizeUnit(DataUnit.GIGABYTES)
    DataSize dataSize;
}
