package com.fastcampus.springbootpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastcampusSpringBootPracticeApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FastcampusSpringBootPracticeApplication.class);
//        application.setApplicationStartup(new FlightRecorderApplicationStartup());
        application.setApplicationStartup(new BufferingApplicationStartup(1000));
        application.run(args);
    }

}
