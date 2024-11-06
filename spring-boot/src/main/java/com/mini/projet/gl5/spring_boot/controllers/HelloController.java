package com.mini.projet.gl5.spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mini.projet.gl5.spring_boot.services.HelloService;

@RestController
public class HelloController {
    private HelloService service;

    @Autowired
    public HelloController(HelloService service) {
        this.service = service;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index() {
        return new ResponseEntity<Object>(service.indexCall(), HttpStatus.OK);
    }

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> hello() {
        return new ResponseEntity<Object>(service.helloCall(), HttpStatus.OK);
    }
}