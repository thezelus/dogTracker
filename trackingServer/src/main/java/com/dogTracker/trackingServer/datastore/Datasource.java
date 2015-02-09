package com.dogTracker.trackingServer.datastore;

import com.dogTracker.model.TrackerData;

import java.util.List;

public interface Datasource {

    public List<String> getAllIds();
    public TrackerData getTrackerDataForId(String id);

}
