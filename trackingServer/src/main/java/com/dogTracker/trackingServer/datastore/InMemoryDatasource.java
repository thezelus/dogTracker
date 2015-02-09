package com.dogTracker.trackingServer.datastore;

import com.dogTracker.model.TrackerData;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class InMemoryDatasource implements Datasource {

    public static ConcurrentMap<String,TrackerData> trackerDataMap = Maps.newConcurrentMap();

    public List<String> getAllIds() {
        return new ArrayList<String>(trackerDataMap.keySet());
    }

    public TrackerData getTrackerDataForId(String id){
        return trackerDataMap.get(id);
    }

}
