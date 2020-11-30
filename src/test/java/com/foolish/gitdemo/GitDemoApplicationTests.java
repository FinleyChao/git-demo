package com.foolish.gitdemo;

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
       /* boolean before = LocalDate.now().isBefore(null);
        System.out.println(before);*/
       /* HashMap<String, List> map = new HashMap<>();
        List key = map.computeIfAbsent("key", k -> Lists.newArrayList());
        key.add("jiushi");
        System.out.println(map);*/
       /*Integer remainder = null;*/
      /* double remainder = 100.0000D;
        boolean equals = Objects.equals(100.00D, remainder);
        System.out.println("equals:" + equals);*/

        String worlds = "The way of the future";
        List<String> list7 = new ArrayList<>();
        list7.add(worlds);
        List<String> list8 = list7.stream().flatMap(str -> Stream.of(str.split(" ")))
                .filter(world -> world.length() > 0).collect(Collectors.toList());
        System.out.println("单词:");
        list8.forEach(System.out::println);
    }

//    @DisplayName("测试断言equals")
    @Test
    @DisplayName("测试断言equals")
    void test1(){
        var str = "  eee  e";

        boolean blank = " ".isBlank();
        String repeat = "Java".repeat(3);
        System.out.println(repeat);

    }

}
