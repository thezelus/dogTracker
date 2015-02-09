package com.dogTracker.trackingServer.config;

import com.dogTracker.trackingServer.datastore.Datasource;
import com.dogTracker.trackingServer.datastore.MockDatasource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestContext {

    @Bean
    public Datasource datasource(){
        return new MockDatasource();
    }

}
