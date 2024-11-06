package com.mini.projet.gl5.spring_boot;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mini.projet.gl5.spring_boot.services.HelloService;

@SpringBootTest
public class HelloServiceTests {
    @Autowired
    private HelloService service;

    @Test
    void indexServiceTest() {
        String[] resp = service.indexCall();

        assertArrayEquals(new String[] { "Index", "Endpoint" }, resp);
    }

    @Test
    void helloServiceTest() {
        String[] resp = service.helloCall();

        assertArrayEquals(new String[] { "Hello", "Endpoint" }, resp);
    }

    @Test
    void sqlInjectionVulnTest() {
        service.sqlInjectionVuln("name");
    }
}
