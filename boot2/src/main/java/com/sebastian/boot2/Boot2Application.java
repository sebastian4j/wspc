package com.sebastian.boot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigurationProperties
@SpringBootApplication
public class Boot2Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot2Application.class, args);
    }
}

@RestController
@RefreshScope
class ProjectNameRestController {

    private final String projectName;

    @Autowired
    public ProjectNameRestController(@Value("${configuration.projectName}") String pn) {
        this.projectName = pn;
    }

    @RequestMapping("/project-name")
    String projectName() {
        return this.projectName;
    }
}