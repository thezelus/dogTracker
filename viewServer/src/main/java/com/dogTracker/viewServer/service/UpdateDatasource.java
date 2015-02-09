package com.dogTracker.viewServer.service;

import com.dogTracker.model.ErrorResponse;
import com.dogTracker.viewServer.datastore.Datasource;
import com.dogTracker.viewServer.model.TrackerResponse;
import com.dogTracker.viewServer.web.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class UpdateDatasource implements Runnable{

    Datasource datasource;

    public UpdateDatasource(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public void run() {
        processTrackerResponseList(getDataFromRemoteDatasource());
    }

    public ArrayList<TrackerResponse> getDataFromRemoteDatasource(){
        RestClient restClient = new RestClient(new RestTemplate(), new ObjectMapper());
        ArrayList<String> ids = restClient.getIdLisFromRemoteServer();
        ArrayList<TrackerResponse> tempList = Lists.newArrayList();
        for(String id : ids){
            TrackerResponse temp = restClient.getTrackerDataForId(id);
            if(temp != null)
                tempList.add(temp);
        }
        return tempList;
    }

    public void processTrackerResponseList(ArrayList<TrackerResponse> responseList){
        for(TrackerResponse trackerResponse: responseList){
            if(trackerResponse.getStatus().is2xxSuccessful()){
                datasource.updateDataForTracker(trackerResponse.getData().getId(), trackerResponse.getData());
            } else if(trackerResponse.getStatus() == HttpStatus.GONE) {
                if(trackerResponse.getError().getCode().equals(ErrorResponse.INVALID_KEY))
                    datasource.removeDataForTracker(trackerResponse.getId());
            }
        }
    }

}
