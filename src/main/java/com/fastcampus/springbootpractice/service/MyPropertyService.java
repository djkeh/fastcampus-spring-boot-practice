package com.fastcampus.springbootpractice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class MyPropertyService {

    private final Integer height;

    public MyPropertyService(@Value("${my.height}") Integer height) {
        this.height = height;
    }

    public Integer getMyHeight() {
        return height;
    }
}
