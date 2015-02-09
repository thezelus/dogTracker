package com.dogTracker.viewServer.datastore;

import com.dogTracker.model.TrackerData;

import java.util.List;

public interface Datasource {

    public List<TrackerData> getDataForAllTrackers();
    public void updateDataForTracker(String id, TrackerData data);
    public void removeDataForTracker(String id);

}
