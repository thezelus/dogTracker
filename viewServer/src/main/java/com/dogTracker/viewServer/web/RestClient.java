package com.dogTracker.viewServer.web;

import com.dogTracker.model.ErrorResponse;
import com.dogTracker.model.TrackerData;
import com.dogTracker.viewServer.config.AppInitializer;
import com.dogTracker.viewServer.model.TrackerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class RestClient {

      private Logger log = Logger.getLogger(RestClient.class);

      RestTemplate restTemplate;
      ObjectMapper objectMapper;

      public RestClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
            this.restTemplate = restTemplate;
            restTemplate.setInterceptors(Collections.<ClientHttpRequestInterceptor>singletonList(new AcceptRequestInterceptor(APPLICATION_JSON)));
            restTemplate.setErrorHandler(new TrackerApiResponseErrorHandler());
            this.objectMapper = objectMapper;
      }

      public ArrayList<String> getIdLisFromRemoteServer(){
            String url = AppInitializer.getAppProperties().getProperty("trackingServer.BaseUrl")
                    + AppInitializer.getAppProperties().getProperty("trackingServer.AllIdsPath");

            String[] idList = restTemplate.getForObject(url,String[].class);
            if(idList == null)
                  return null;

            return Lists.newArrayList(idList);
      }

      public TrackerResponse getTrackerDataForId(String id){
            String url = AppInitializer.getAppProperties().getProperty("trackingServer.BaseUrl")
                    + AppInitializer.getAppProperties().getProperty("trackingServer.IdPath") + "/" + id;

            ResponseEntity<String> responseEntity
                    = restTemplate.getForEntity(url,String.class,"");
            String responseBody = responseEntity.getBody();
            TrackerResponse trackerResponse = null;
            try {
                  if (RestUtil.isError(responseEntity.getStatusCode())) {
                        ErrorResponse errorResponse = objectMapper.readValue(responseBody, ErrorResponse.class);
                        trackerResponse = new TrackerResponse(id, responseEntity.getStatusCode(), null, errorResponse);
                  } else {
                        TrackerData data = objectMapper.readValue(responseBody, TrackerData.class);
                        trackerResponse = new TrackerResponse(id, responseEntity.getStatusCode(), data, null);
                  }
            }catch (IOException e) {
                  log.error("IOException in getTrackerDataForId: " + e.getMessage());
                  throw new RuntimeException(e);
            }
            log.info(trackerResponse);
            return trackerResponse;
      }


}
