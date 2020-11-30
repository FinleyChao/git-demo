package com.foolish.gitdemo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        String contentAsString = mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8083/hello/world?message=" + "hyh")          //请求的url,请求的方法是post
                        //get("/user/showUser2")          //请求的url,请求的方法是get
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)//发送数据的格式
//                        .param("message", "hyh")   //添加参数(可以添加多个)
//                        .param("password", "123")   //添加参数(可以添加多个)
        ).andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

}