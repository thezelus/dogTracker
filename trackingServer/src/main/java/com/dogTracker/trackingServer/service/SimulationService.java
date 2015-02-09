package com.dogTracker.trackingServer.service;

import com.dogTracker.model.TrackerData;
import com.dogTracker.trackingServer.model.SimulationParameters;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SimulationService {

    public static ConcurrentMap<String, TrackerData> generateSimulatedRFIdTracker(int n){
        if(n < 0)
            throw new IllegalArgumentException("Value of n cannot be less than 0");

        ConcurrentMap<String, TrackerData> trackerDataMap = new ConcurrentHashMap<String, TrackerData>();

        for(int i = 1; i <= n ; i++){
            String tempId = "id" + Integer.toString(i);
            TrackerData tempData = new TrackerData(tempId,0,0,0,0.0f);
            trackerDataMap.put(tempId, tempData);
        }

        return trackerDataMap;
    }

    public static void simulateDataChange(SimulationParameters parameters, ConcurrentMap<String,TrackerData> trackerDataMap) {

        ConcurrentMap<String,TrackerData> tempMap = new ConcurrentHashMap<String, TrackerData>();

        for(String key : trackerDataMap.keySet()){
            TrackerData newData = randomlyGeneratedLocationAndVitalForGivenId(key,parameters);
            tempMap.put(key,newData);
        }
        trackerDataMap.putAll(tempMap);
    }

    static TrackerData randomlyGeneratedLocationAndVitalForGivenId(String id, SimulationParameters parameters){
        Random rand = new Random();
        int newX, newY, newHeartbeat;
        float newTemp;

        newX = rand.nextInt(parameters.xUpperBound - parameters.xLowerBound + 1) + parameters.xLowerBound;
        newY = rand.nextInt(parameters.yUpperBound - parameters.yLowerBound + 1) + parameters.yLowerBound;
        newHeartbeat = rand.nextInt(parameters.heartbeatUpperBound - parameters.hearbeatLowerBound + 1)
                + parameters.hearbeatLowerBound;
        newTemp = rand.nextFloat()*(parameters.temperatureUpperBound - parameters.temperatureLowerBound)
                + parameters.temperatureLowerBound;

        return new TrackerData(id, newX, newY, newHeartbeat, newTemp);
    }

}
