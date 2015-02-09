package com.dogTracker.viewServer.datastore;

import com.dogTracker.model.TrackerData;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class InMemoryDatasource implements Datasource {

    public static ConcurrentMap<String,TrackerData> viewServerTrackerDataMap = Maps.newConcurrentMap();

    @Override
    public List<TrackerData> getDataForAllTrackers() {
        return new ArrayList<TrackerData>(viewServerTrackerDataMap.values());
    }

    @Override
    public void updateDataForTracker(String id, TrackerData data) {
        viewServerTrackerDataMap.put(id, data);
    }

    @Override
    public void removeDataForTracker(String id) {
        viewServerTrackerDataMap.remove(id);
    }
}
