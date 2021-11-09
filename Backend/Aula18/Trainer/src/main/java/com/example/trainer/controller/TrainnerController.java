package com.example.trainer.controller;


import com.example.trainer.model.Trainer;
import com.example.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trainer")
public class TrainnerController {
    private final TrainerService trainerService;

    @Autowired
    public TrainnerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @GetMapping
    @RequestMapping("listar")
    public List<Trainer> getTrainer(){
        return trainerService.listTrainer();
    }
}
