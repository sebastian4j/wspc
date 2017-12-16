package com.sebastian.boot2;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {

        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("customers").build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource ds) {
        return new JdbcTemplate(ds);
    }
    
    /**
     * utilizando el PropertyPlaceholderConfigurer se cargan desde aca los properties
     * y no se considera el perfil, xej: si se activa el perfil desa no se carga automaticamente
     * el application-desa.properties, solo se carga el application.properties automaticamente.
     */

//    @Bean
//    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws IOException {
//        final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
//        ppc.setLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath*:*.properties"));
//        return ppc;
//
//    }
}
