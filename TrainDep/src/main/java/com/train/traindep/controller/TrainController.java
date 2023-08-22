package com.train.traindep.controller;

import com.train.traindep.service.TrainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainController {

    private final TrainService trainservice;

    public TrainController(TrainService trainservice) {
        this.trainservice = trainservice;
    }

    @RequestMapping("/")
    public ResponseEntity<String> Train(){
        return trainservice.getTrains();
    }
}
