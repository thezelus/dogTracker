package com.dogTracker.viewServer.config;

import com.dogTracker.viewServer.datastore.InMemoryDatasource;
import com.dogTracker.viewServer.service.UpdateDatasource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppInitializer {

    static Properties appProperties;
    static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private AppInitializer(){}

    public static void initializeApp(String propertyFilename){
        appProperties = readPropertiesFile(propertyFilename);
        int interval = Integer.parseInt(appProperties.getProperty("outboundRequestIntervalInMilliseconds"));
        scheduler.scheduleAtFixedRate(new UpdateDatasource(new InMemoryDatasource()),100,interval,TimeUnit.MILLISECONDS);
    }

    public static void stopApp() {
        scheduler.shutdown();
    }

    public static Properties getAppProperties() {
        return appProperties;
    }


    static Properties readPropertiesFile(String propertyFilename) {
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
}
