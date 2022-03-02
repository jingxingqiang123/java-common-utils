package com.core.log.controller;

import com.core.log.aspect.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class HelloController {
    @GetMapping("hello")
    @Log(target = "111")
    public String hello(@RequestParam("name") String name) {
        log.info("====:{}", name);
        return "jxq" + name;
    }
}
