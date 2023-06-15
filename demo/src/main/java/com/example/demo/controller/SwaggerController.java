package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.apache.commons.io.IOUtils;

@Controller
public class SwaggerController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/swagger.yaml")
    public ResponseEntity<String> getSwaggerYaml() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:swagger.yaml");
        InputStream inputStream = resource.getInputStream();
        String swaggerYaml = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        return ResponseEntity.ok(swaggerYaml);
    }

    @GetMapping("/swagger-html")
    public ResponseEntity<Resource> getSwaggerHtml() {
        Resource resource = resourceLoader.getResource("./src/main/resources/static/swagger.html");
        return ResponseEntity.ok(resource);
    }
}