package com.foolish.gitdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author finley.chao
 * @create 2020/8/13 15:53
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    public ResponseEntity world(@RequestParam String message){
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
