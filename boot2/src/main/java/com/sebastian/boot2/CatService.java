package com.sebastian.boot2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CatService {
    @Value("${saludo}")
    private String saludo;
    @Value("${hola}")
    private String hola;
    @Value("${saludo.perfil}")
    private String saludoPerfil;
    
    private Log log = LogFactory.getLog(getClass());   
    @Autowired
    private GeneradorNombres gn;
    private final DataSource dataSource;

    public CatService(final DataSource ds) {
        this.dataSource = ds;        
    }
    @Autowired
    public void ingresarCats(CatRepository catRepository) {
        log.info("valor de saludo: " + saludo);
        log.info("valor de hola: " + hola);
        log.info("saludo perfil: " + saludoPerfil);
        gn.generarNombres().forEach(n -> catRepository.save(new Cat(n)));
    }    
    @PreDestroy
    public void pre() {
        log.info("pre destroy");
    }
    @PostConstruct
    public void post() {
        log.info("post constructor");
    }
}
