package com.dogTracker.trackingServer.config;

import com.dogTracker.trackingServer.datastore.Datasource;
import com.dogTracker.trackingServer.datastore.InMemoryDatasource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dogTracker.trackingServer")
public class WebConfig {
    @Bean
    public Datasource datasource(){
        return new InMemoryDatasource();
    }

}
