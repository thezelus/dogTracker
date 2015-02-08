package com.dogTracker.trackingServer.datastore;

import com.dogTracker.model.TrackerData;
import com.dogTracker.trackingServer.service.SimulationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Datasource {

    public static ConcurrentMap<String,TrackerData> trackerDataMap;

    public List<String> getAllIds() {
        return new ArrayList<String>(trackerDataMap.keySet());
    }

    public TrackerData getTrackerDataForId(String id){
        return trackerDataMap.get(id);
    }

}
