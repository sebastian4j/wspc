package com.sebastian.boot2;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class Produccion {
    private Log log = LogFactory.getLog(getClass());
    
    @Value("${configuration.projectName}")
    private String projectName;
    
    @PostConstruct
    public void post() {
        log.info("post bean produccion " + projectName);
    }
    @Bean
    public GeneradorNombres nombres() {
        return new GeneradorNombresProduccion();
    }
}
