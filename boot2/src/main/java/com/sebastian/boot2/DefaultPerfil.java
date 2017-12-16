package com.sebastian.boot2;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties("default")
@Component
@Data
public class DefaultPerfil {    
    private String nombre;    
    private int cantidad;
    
    private Log log = LogFactory.getLog(getClass());
    @PostConstruct
    public void post() {
        log.info("post bean default perfil " + nombre + " " + cantidad);
    }
}
