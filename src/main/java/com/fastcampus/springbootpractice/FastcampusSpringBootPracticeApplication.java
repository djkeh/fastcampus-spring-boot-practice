package com.fastcampus.springbootpractice;

import com.fastcampus.springbootpractice.properties.MyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;

import javax.annotation.PostConstruct;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastcampusSpringBootPracticeApplication {

    private final MyProperties myProperties;

    public FastcampusSpringBootPracticeApplication(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FastcampusSpringBootPracticeApplication.class);
//        application.setApplicationStartup(new FlightRecorderApplicationStartup());
        application.setApplicationStartup(new BufferingApplicationStartup(1000));
        application.run(args);
    }

    @PostConstruct
    public void init() {
        System.out.println("[configurationProps] " + myProperties.getHeight());
    }

}
