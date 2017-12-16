package com.sebastian.boot2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ConfigurationProperties("saludo")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class Boot2ApplicationTests {
    private Log log = LogFactory.getLog(getClass());
    @Value("${saludo}")
    private String saludo;
    @Value("${hola}")
    private String hola;
    
    private String perfil;
    
    @Autowired
    private GeneradorNombres gn;
    
    @Autowired
    private MockMvc mvc;

    @Autowired
    private CatRepository catRepository;

    @Before
    public void before() throws Exception {
        log.info("saludo: " + saludo);
        log.info("hola: " + hola);                
        log.info("perfil: " + perfil);
        log.info("total de elementos: " + gn.generarNombres().count());
        catRepository.deleteAll();
        gn.generarNombres().forEach(n -> catRepository.save(new Cat(n)));
    }

    @Test
    public void catsReflectedInRead() throws Exception {       
        MediaType halJson = MediaType.parseMediaType("application/hal+json;charset=UTF-8");
        this.mvc.perform(MockMvcRequestBuilders.get("/cats")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(halJson)).andExpect(mvcResult -> {
                    String contentAsString = mvcResult.getResponse().getContentAsString();
                    Assert.assertTrue(contentAsString.split("totalElements")[1].split(":")[1].trim().split(",")[0].equals("3"));
                });
    }
}
