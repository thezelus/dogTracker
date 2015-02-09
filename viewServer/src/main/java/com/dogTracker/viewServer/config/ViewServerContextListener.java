package com.dogTracker.viewServer.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ViewServerContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AppInitializer.initializeApp("viewServer.properties");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        AppInitializer.stopApp();
    }
}
