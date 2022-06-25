package com.myxx.tktest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class TktestApplicationTests {

    @Test
    void contextLoads() {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(3,"xiaoming");
        map.put(1,"qqqq");
        map.put(6,"wwwww");
        map.put(4,"33333");
        for (Integer integer : map.keySet()) {

            String s = map.get(integer);
            System.out.println(integer+"=="+ s);
        }

    }

}
