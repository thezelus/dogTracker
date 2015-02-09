package com.dogTracker.viewServer.model;

import com.dogTracker.model.ErrorResponse;
import com.dogTracker.model.TrackerData;
import org.springframework.http.HttpStatus;

public class TrackerResponse {

    String id;
    HttpStatus status;
    TrackerData data;
    ErrorResponse error;

    public TrackerResponse() {
    }

    public TrackerResponse(String id, HttpStatus status, TrackerData data, ErrorResponse error) {
        this.id = id;
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public TrackerData getData() {
        return data;
    }

    public void setData(TrackerData data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
