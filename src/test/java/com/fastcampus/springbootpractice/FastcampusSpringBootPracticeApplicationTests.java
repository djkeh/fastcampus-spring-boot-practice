package com.fastcampus.springbootpractice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
class FastcampusSpringBootPracticeApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(FastcampusSpringBootPracticeApplicationTests.class);

    @Container
    private static final GenericContainer<?> redisContainer = new GenericContainer<>(DockerImageName.parse("redis:latest"));

    @BeforeAll
    static void setup() {
        redisContainer.followOutput(new Slf4jLogConsumer(logger));
    }

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.redis.port", () -> redisContainer.getMappedPort(6379));
    }

    @Test
    void contextLoads() {
        // Given

        // When

        // Then
        assertThat(redisContainer.isRunning()).isTrue();
    }

}
