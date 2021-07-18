package com.fastcampus.springbootpractice;

import com.fastcampus.springbootpractice.properties.MyProperties;
import com.fastcampus.springbootpractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@ConfigurationPropertiesScan
@SpringBootApplication
public class FastcampusSpringBootPracticeApplication {

    private final MyProperties myProperties;
    private final StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(FastcampusSpringBootPracticeApplication.class, args);
    }

    @PostConstruct
    public void init() {
//        System.out.println("내 키는: " + myProperties.getHeight());
        studentService.printStudent("jack");
    }

}
