package com.dogTracker.viewServer.controller;

import com.dogTracker.model.TrackerData;
import com.dogTracker.viewServer.datastore.Datasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewDataController {

    @Autowired
    Datasource datasource;

    @RequestMapping(value = "/liveData", method = RequestMethod.GET)
    public List<TrackerData> getDataList(){
        return datasource.getDataForAllTrackers();
    }
}
