package com.core.controller;

import com.core.common.aspect.Log;
import com.core.common.exception.BaseException;
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

    @GetMapping("hello2")
    @Log(target = "exception")
    public String hello2(@RequestParam("exception") String exception) {
        throw new BaseException(20000L, "dsdsdsd", new String[]{"sdsdsdsd"});
    }
}
