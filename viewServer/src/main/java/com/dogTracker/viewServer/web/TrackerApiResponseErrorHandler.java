package com.dogTracker.viewServer.web;

import org.apache.log4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class TrackerApiResponseErrorHandler implements ResponseErrorHandler {

    private Logger log = Logger.getLogger(TrackerApiResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return RestUtil.isError(response.getStatusCode());
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        log.error("Response error: {" + response.getStatusCode() +"}, {" + response.getStatusText() +"}");
    }
}
