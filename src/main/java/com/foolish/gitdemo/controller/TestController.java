package com.foolish.gitdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author：chaoxianfei
 * @date：2020/3/31 9:26
 */
@RestController
public class TestController {

    @GetMapping("/test-demo")
    public String test(){
        return "/test-demo/我是一个pro分支";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id){
        return id.toString();
    }
}
