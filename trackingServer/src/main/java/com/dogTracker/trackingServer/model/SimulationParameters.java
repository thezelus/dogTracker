package com.dogTracker.trackingServer.model;

public class SimulationParameters {

    public static int HEARTBEAT_FLOOR = 40;
    public static int HEARTBEAT_CEILING = 200;

    public static float BODYTEMP_FLOOR = 97.0f;
    public static float BODYTEMP_CEILING = 104.0f;

    public int xLowerBound;
    public int xUpperBound;

    public int yLowerBound;
    public int yUpperBound;

    public int hearbeatLowerBound;
    public int heartbeatUpperBound;

    public float temperatureLowerBound;
    public float temperatureUpperBound;


    public SimulationParameters(int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound) {
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;

        this.hearbeatLowerBound = HEARTBEAT_FLOOR;
        this.heartbeatUpperBound = HEARTBEAT_CEILING;

        this.temperatureLowerBound = BODYTEMP_FLOOR;
        this.temperatureUpperBound = BODYTEMP_CEILING;
    }

    public SimulationParameters(int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound,
                                int hearbeatLowerBound, int heartbeatUpperBound, float temperatureLowerBound,
                                float temperatureUpperBound) {
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
        this.hearbeatLowerBound = hearbeatLowerBound;
        this.heartbeatUpperBound = heartbeatUpperBound;
        this.temperatureLowerBound = temperatureLowerBound;
        this.temperatureUpperBound = temperatureUpperBound;
    }
}
