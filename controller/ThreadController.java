package com.example.demo_practise.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ThreadController
 * Description:
 * date: 2022/7/9 13:26
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
@Api("多线程操作controller")
@RestController
@RequestMapping("/thread")
public class ThreadController {
    @GetMapping("test")
    public String test() {
        return "success!";
    }
}
