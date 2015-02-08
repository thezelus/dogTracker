package com.dogTracker.trackingServer.service;

import com.dogTracker.model.TrackerData;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SimulationService {

    public ConcurrentMap<String, TrackerData> generateSimulatedRFIdTracker(int n){
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
}
