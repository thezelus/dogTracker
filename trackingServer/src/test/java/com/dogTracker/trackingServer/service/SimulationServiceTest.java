package com.dogTracker.trackingServer.service;

import com.dogTracker.model.TrackerData;
import com.dogTracker.trackingServer.model.SimulationParameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.ConcurrentMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SimulationServiceTest {

    static SimulationService testService = new SimulationService();
    static ConcurrentMap<String,TrackerData> staticTestDataMap = testService.generateSimulatedRFIdTracker(10);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGenerateSimulatedRFIdTracker() throws Exception {

        SimulationService testService = new SimulationService();
        ConcurrentMap<String,TrackerData> actualData = testService.generateSimulatedRFIdTracker(10);

        assertThat(actualData.size(), equalTo(10));
        assertTrue(actualData.containsKey("id1"));
        assertTrue(actualData.containsKey("id10"));

        assertThat(actualData.get("id3").getId(), equalTo("id3"));
    }

    @Test
    public void testGenerateSimulatedRFIdTracker_ExceptionAssertion() {
        thrown.expect(IllegalArgumentException.class);
        SimulationService testService = new SimulationService();
        testService.generateSimulatedRFIdTracker(-1);
    }

    @Test
    public void testSimulateDataChange() throws Exception {

        SimulationParameters parameters = new SimulationParameters(0,10,0,10);
        testService.simulateDataChange(parameters, staticTestDataMap);

        TrackerData actualData = staticTestDataMap.get("id2");
        System.out.println(actualData.toString());

    }
}