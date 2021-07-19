package com.fastcampus.springbootpractice;

import com.fastcampus.springbootpractice.properties.MyProperties;
import com.fastcampus.springbootpractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastcampusSpringBootPracticeApplication {

    private final MyProperties myProperties;
    private final StudentService studentService;
    private final String username;
    private final String password;

    public FastcampusSpringBootPracticeApplication(
            MyProperties myProperties,
            StudentService studentService,
            @Value("${spring.datasource.username:}") String username,
            @Value("${spring.datasource.password:}") String password
    ) {
        this.myProperties = myProperties;
        this.studentService = studentService;
        this.username = username;
        this.password = password;
    }

    public static void main(String[] args) {
        SpringApplication.run(FastcampusSpringBootPracticeApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
//        System.out.println("내 키는: " + myProperties.getHeight());
//        studentService.printStudent("jack");
//        studentService.printStudent("jack");
//        studentService.printStudent("jack");
//        studentService.printStudent("fred");
//        studentService.printStudent("cassie");
//        studentService.printStudent("cassie");
//        System.out.println("user: " + username);
//        System.out.println("pw: " + password);
    }

}
