package com.fastcampus.springbootpractice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@ConstructorBinding
@ConfigurationProperties("iam")
public class CustomProperties {

    /**
     * 와아 이건 configuration processor 테스트
     */
    private final Duration duration;

    public CustomProperties(@DefaultValue("1") @DurationUnit(ChronoUnit.MILLIS) @Name("duration") Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

}