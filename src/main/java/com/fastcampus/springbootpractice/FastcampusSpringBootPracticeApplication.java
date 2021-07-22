package com.fastcampus.springbootpractice;

import com.fastcampus.springbootpractice.properties.MyProperties;
import com.fastcampus.springbootpractice.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

@EnableConfigServer
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
            @Value("${spring.datasource.username:vault가}") String username,
            @Value("${spring.datasource.password:꺼져 있어요}") String password
    ) {
        this.myProperties = myProperties;
        this.studentService = studentService;
        this.username = username;
        this.password = password;
    }

    public static void main(String[] args) {
        SpringApplication.run(FastcampusSpringBootPracticeApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("내 키는: " + myProperties.getHeight());
            studentService.printStudent("jack");
            studentService.printStudent("jack");
            studentService.printStudent("jack");
            studentService.printStudent("fred");
            studentService.printStudent("cassie");
            studentService.printStudent("cassie");
            System.out.println("user: " + username);
            System.out.println("pw: " + password);
        };
    }

}
