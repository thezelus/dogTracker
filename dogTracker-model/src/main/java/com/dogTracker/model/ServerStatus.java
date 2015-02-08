package com.dogTracker.model;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ServerStatus {
    public String status;
    public String current;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public ServerStatus(String status) {
        this.status = status;
        this.current = DateTime.now(DateTimeZone.UTC).toString();
    }
}
