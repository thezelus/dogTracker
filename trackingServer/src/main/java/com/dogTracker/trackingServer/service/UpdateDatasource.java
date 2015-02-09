package com.dogTracker.trackingServer.service;

import com.dogTracker.trackingServer.datastore.InMemoryDatasource;
import com.dogTracker.trackingServer.model.SimulationParameters;


public class UpdateDatasource implements Runnable {

    SimulationParameters simulationParameters;

    public UpdateDatasource(SimulationParameters simulationParameters) {
        this.simulationParameters = simulationParameters;
    }

    @Override
    public void run() {
       SimulationService.simulateDataChange(simulationParameters, InMemoryDatasource.trackerDataMap);
    }
}
