package com.dogTracker.viewServer.controller;

import com.dogTracker.model.ServerStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public ServerStatus getServerStatus(){
        return new ServerStatus("Server is running");
    }
}
