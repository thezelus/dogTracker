package com.dogTracker.trackingServer.config;

import com.dogTracker.trackingServer.datastore.InMemoryDatasource;
import com.dogTracker.trackingServer.model.SimulationParameters;
import com.dogTracker.trackingServer.service.SimulationService;
import com.dogTracker.trackingServer.service.UpdateDatasource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppInitializer {
    static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    SimulationParameters simulationParameters;
    int rfidCount;
    int dataUpdatePeriod;

    public AppInitializer(String propertyFilename) {
        Properties prop = readPropertiesFile(propertyFilename);
        simulationParameters = readSimulationParamsFromProperties(prop) ;
        rfidCount = Integer.parseInt(prop.getProperty("rfidCount"));
        dataUpdatePeriod = Integer.parseInt(prop.getProperty("dataUpdatePeriod"));
    }

    public void initializeApp() {
        InMemoryDatasource.trackerDataMap = SimulationService.generateSimulatedRFIdTracker(rfidCount);
        scheduler.scheduleAtFixedRate(new UpdateDatasource(simulationParameters),500, dataUpdatePeriod, TimeUnit.MILLISECONDS);
    }

    public void stopApp() {
        scheduler.shutdown();
    }

    Properties readPropertiesFile(String propertyFilename) {
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("/"+propertyFilename);
        try {
            prop.load(stream);
        } catch (IOException e) {
            throw new RuntimeException("Cannot load properties from file:" + propertyFilename);
        }
        return prop;
    }



    SimulationParameters readSimulationParamsFromProperties(Properties prop){
        int xLow = Integer.parseInt(prop.getProperty("xLower"));
        int xUpper = Integer.parseInt(prop.getProperty("xUpper"));
        int yLow = Integer.parseInt(prop.getProperty("yLower"));
        int yUpper = Integer.parseInt(prop.getProperty("yUpper"));

        return new SimulationParameters(xLow,xUpper,yLow,yUpper);
    }

}
