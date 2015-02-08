package com.dogTracker.trackingServer.service;

import com.dogTracker.model.TrackerData;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.ConcurrentMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class SimulationServiceTest {

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
}