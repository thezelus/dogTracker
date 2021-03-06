package com.dogTracker.trackingServer.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TrackingServerContextListener implements ServletContextListener {

    AppInitializer initializer = new AppInitializer("trackingServer.properties");

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        initializer.initializeApp();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        initializer.stopApp();
    }
}
