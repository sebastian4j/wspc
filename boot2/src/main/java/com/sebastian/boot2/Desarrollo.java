package com.sebastian.boot2;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("desa")
public class Desarrollo {
    private Log log = LogFactory.getLog(getClass());
    @PostConstruct
    public void post() {
        log.info("post bean desarrollo");
    }
    
    @Bean
    public GeneradorNombres nombres() {
        return new GeneradorNombresDesarrollo();
    }
}
