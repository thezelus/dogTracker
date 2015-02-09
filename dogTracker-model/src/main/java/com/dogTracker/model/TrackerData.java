package com.dogTracker.model;

public class TrackerData {
    public String id;
    public int xCoordinate;
    public int yCoordinate;
    public int heartRate;
    public float bodyTemperatureInFahrenheit;

    public TrackerData() {
    }

    public TrackerData(String id, int xCoordinate, int yCoordinate, int heartRate, float bodyTemperatureInFahrenheit) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.heartRate = heartRate;
        this.bodyTemperatureInFahrenheit = bodyTemperatureInFahrenheit;
    }

    public void setLocation(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void setVitals(int heartRate, int bodyTemperatureInFahrenheit){
        this.heartRate = heartRate;
        this.bodyTemperatureInFahrenheit = bodyTemperatureInFahrenheit;
    }

    @Override
    public String toString() {
        return "com.thezelus.model.TrackerData{" +
                "id='" + id + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", heartRate=" + heartRate +
                ", bodyTemperatureInFahrenheit=" + bodyTemperatureInFahrenheit +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public float getBodyTemperatureInFahrenheit() {
        return bodyTemperatureInFahrenheit;
    }

    public void setBodyTemperatureInFahrenheit(float bodyTemperatureInFahrenheit) {
        this.bodyTemperatureInFahrenheit = bodyTemperatureInFahrenheit;
    }
}
