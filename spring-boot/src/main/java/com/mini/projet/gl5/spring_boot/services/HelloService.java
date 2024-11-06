package com.mini.projet.gl5.spring_boot.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String[] indexCall() {
        String[] resp = new String[2];
        resp[0] = "Index";
        resp[1] = "Endpoint";
        return resp;
    }

    public String[] helloCall() {
        String[] resp = new String[2];
        resp[0] = "Hello";
        resp[1] = "Endpoint";
        return resp;
    }
}
