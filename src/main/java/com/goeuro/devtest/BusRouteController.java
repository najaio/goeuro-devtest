package com.goeuro.devtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusRouteController {

    @Autowired
    private BusRouteService service;
    
    @RequestMapping("/api/direct")
    public Route findDirectRoute(@RequestParam(value = "dep_sid") int from, 
                                 @RequestParam(value = "arr_sid") int to) {
        
        boolean direct = service.findDirectRoute(to, from);
        
        return new Route(from, to, direct);
        
    }
}

