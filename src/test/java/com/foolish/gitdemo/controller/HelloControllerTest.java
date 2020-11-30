package com.foolish.gitdemo.controller;

import com.google.common.collect.HashMultimap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Finley.Chao@movitech.com
 * @version 0.1
 * @since 2020/10/14
 */
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @AutoConfigureMockMvc
    @DisplayName("测试断言equals")
    void test1() throws Exception {

    }

}