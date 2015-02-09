package com.dogTracker.trackingServer.datastore;

import com.dogTracker.model.TrackerData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class MockDatasource implements Datasource {

    public static ConcurrentMap<String,TrackerData> mockDataMap;

    public MockDatasource() {
        mockDataMap.put("1", new TrackerData("1",1,1,1,1.0f));
        mockDataMap.put("2", new TrackerData("2",2,2,2,2.0f));
    }

    @Override
    public List<String> getAllIds() {
        return new ArrayList<String>(mockDataMap.keySet());
    }

    @Override
    public TrackerData getTrackerDataForId(String id) {
        return mockDataMap.get(id);
    }
}
