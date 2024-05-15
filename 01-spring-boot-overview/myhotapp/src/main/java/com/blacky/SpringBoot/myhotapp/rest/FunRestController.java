package com.blacky.SpringBoot.myhotapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
//    expose '/' that returns "Hello World!"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
//    expose new endpoint for workout
@GetMapping("/workout")
public String doWorkout(){
    return "Run daily 5KM!";
}

//inject properties  for : coach.name and team.name
@Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
//    expose new endpoint for teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach Name: " + coachName +", Team Name: "+teamName;
    }
}
