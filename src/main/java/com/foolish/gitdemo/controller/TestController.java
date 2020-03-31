package com.foolish.gitdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author：chaoxianfei
 * @date：2020/3/31 9:26
 */
@RestController
public class TestController {

    @GetMapping("/pro")
    public String test(){
        return "pro";
    }
}
