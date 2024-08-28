package com.example.bookstoreapi.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    public void customMetrics(MeterRegistry meterRegistry) {
        meterRegistry.counter("custom.book.count", "type", "books");
        meterRegistry.gauge("custom.book.price.avg", 100); // Example gauge metric with a fixed value
    }
}
