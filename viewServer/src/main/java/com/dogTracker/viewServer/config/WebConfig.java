package com.dogTracker.viewServer.config;

import com.dogTracker.viewServer.datastore.Datasource;
import com.dogTracker.viewServer.datastore.InMemoryDatasource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dogTracker.viewServer")
public class WebConfig {

    @Bean
    public Datasource datasource(){
        return new InMemoryDatasource();
    }

}
