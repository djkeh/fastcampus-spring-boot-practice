package com.fastcampus.springbootpractice.controller;

import com.fastcampus.springbootpractice.properties.MyProperties;
import com.fastcampus.springbootpractice.service.MyPropertyService;
import com.fastcampus.springbootpractice.service.SortService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final SortService sortService;
    private final MyPropertyService myPropertyService;
    private final MyProperties myProperties;
    private final ContextRefresher contextRefresher;


    @GetMapping("/")
    public String hello(@RequestParam List<String> list) {
        return sortService.doSort(list).toString();
    }

    @GetMapping("/my-height")
    public Map<String, Integer> myHeight() {
        return Map.of(
                "- my.height(@Value from service): ", myPropertyService.getMyHeight(),
                "- my.height(@ConfigurationProperties): ", myProperties.getHeight()
        );
    }

    @GetMapping("/refresh")
    public Map<String, Set<String>> refresh() {
        return Map.of("refreshResult", contextRefresher.refresh());
    }

}
