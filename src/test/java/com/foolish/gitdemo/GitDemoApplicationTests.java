package com.foolish.gitdemo;

import com.google.common.collect.HashMultimap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
class GitDemoApplicationTests {

    @Test
    void contextLoads() {
        // use guava
        HashMultimap<String, String> multimap = HashMultimap.create();
        multimap.put("狗", "大黄");
        multimap.put("狗", "旺财");
        multimap.put("猫", "加菲");
        multimap.put("猫", "汤姆");
        System.out.println(multimap.get("猫")); // [加菲, 汤姆]
    }

//    @DisplayName("测试断言equals")
    @Test
    @DisplayName("测试断言equals")
    void test1(){
        var str = "  eee  e";
        System.out.println("1111111111");
        boolean blank = " ".isBlank();
        String repeat = "Java".repeat(3);
        System.out.println(repeat);

    }

}
