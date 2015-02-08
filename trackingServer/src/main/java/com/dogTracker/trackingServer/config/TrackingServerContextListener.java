package com.dogTracker.trackingServer.config;

import com.dogTracker.trackingServer.datastore.Datasource;
import com.dogTracker.trackingServer.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TrackingServerContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SimulationService simulationService = new SimulationService();
        Datasource.trackerDataMap = simulationService.generateSimulatedRFIdTracker(100);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
