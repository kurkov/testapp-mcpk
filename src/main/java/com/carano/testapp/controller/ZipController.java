package com.carano.testapp.controller;

import com.carano.testapp.service.ZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZipController {

    @Autowired
    private ZipService zipService;

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/api/zip")
    public List<String> getAllZips() {
        return zipService.getAllZipCodes();
    }

    // another mapping that allows to find all Cities for a given zipCode
    // please notice that you need to use the proper annotations and mappings in order
    // swagger-ui to be able to call it. Use zipService.getAllCitiesByZipCode( String zipCode ) to implement it.
    @GetMapping("/api/zip/{zipCode}")
    public List<String> getAllCitiesByZipCode(@PathVariable("zipCode") @NonNull String zipCode) {
        return zipService.getAllCitiesByZipCode(zipCode);
    }
}
