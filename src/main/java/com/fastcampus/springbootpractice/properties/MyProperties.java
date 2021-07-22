package com.fastcampus.springbootpractice.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@Setter
//@RequiredArgsConstructor
//@ConstructorBinding
@ConfigurationProperties("my")
public class MyProperties {

    /** 제 키에요. */
    private Integer height;

}
