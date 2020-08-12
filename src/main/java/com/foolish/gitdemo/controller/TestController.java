package com.foolish.gitdemo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @description:
 * @author：chaoxianfei
 * @date：2020/3/31 9:26
 */
@RestController
public class TestController {

    @GetMapping("/test-demo")
    public String test(){
        return "/test-demo/我是一个测试分支";
    }

    @PostMapping("")
    public String save(){
        Random random = new Random();
        int i = random.nextInt();
        return String.valueOf(i);
    }
}
