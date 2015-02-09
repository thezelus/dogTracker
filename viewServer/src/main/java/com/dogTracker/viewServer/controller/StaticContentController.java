package com.dogTracker.viewServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticContentController {

    @RequestMapping(value = "/canvas")
    public String getCanvas(){
        return "static/canvas.html";
    }
}
