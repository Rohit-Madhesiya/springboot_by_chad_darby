package com.blacky.springcoredemo.rest;

import com.blacky.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
//    private Coach anotherCoach;
//    @Autowired
//    DemoController(Coach ch){
//        myCoach=ch;
//    }
//    @Autowired
//    public DemoController(@Qualifier("trackCoach") Coach ch){
//        myCoach=ch;
//    }
@Autowired
public DemoController(@Qualifier("aquatic") Coach thecoach){
//                      @Qualifier("cricketCoach") Coach another
//){
    System.out.println("In Constructor: "+getClass().getSimpleName());
    myCoach=thecoach;
//    anotherCoach=another;
}
//@GetMapping("/check")
//public String check(){
//    return "Comparing Beans: (myCoach == anotherCoach) : "+(myCoach==anotherCoach);
//}

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
