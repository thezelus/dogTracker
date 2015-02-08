package com.dogTracker.trackingServer.config;

import com.dogTracker.trackingServer.datastore.Datasource;
import com.dogTracker.trackingServer.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dogTracker.trackingServer")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Datasource datasource(){
        return new Datasource();
    }

    @Bean
    public SimulationService simulationService() {
        return new SimulationService();
    }

}
