package com.learningjava.rest.spring.front.controller;


import com.learningjava.rest.spring.core.ReadDB;
import com.learningjava.rest.spring.core.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "/rest/api/v1")
public class ApiRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();



    @RequestMapping(path = "/restaurants",method = RequestMethod.GET)
    public List<Restaurant> list() {
        ReadDB readdb = new ReadDB();
        List<Restaurant> arrData = readdb.readRestaurant();
        return arrData;
    }

}
