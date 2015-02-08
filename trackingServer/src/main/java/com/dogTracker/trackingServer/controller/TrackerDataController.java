package com.dogTracker.trackingServer.controller;

import com.dogTracker.model.ErrorResponse;
import com.dogTracker.model.TrackerData;
import com.dogTracker.trackingServer.datastore.Datasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class TrackerDataController {

    @Autowired
    private Datasource source;


    @RequestMapping(value = "/ids", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllTrackerIds(){
        return new ResponseEntity<List<String>>(source.getAllIds(), HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getTrackerData(@PathVariable String id) {
        TrackerData data = source.getTrackerDataForId(id);
        if(data != null)
            return new ResponseEntity<TrackerData>(data, HttpStatus.OK);
        else {
            ErrorResponse errorResponse = new ErrorResponse(ErrorResponse.INVALID_KEY,
                    "Value associated with this key is null",
                    "");
            return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

}
