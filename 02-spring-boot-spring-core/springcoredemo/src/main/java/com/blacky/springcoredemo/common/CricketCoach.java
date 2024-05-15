package com.blacky.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Lazy
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }

//    define init method
//    @PostConstruct
//    public void doMyStartupStuff(){
//        System.out.println( "In DoMyStartupStuff(): "+getClass().getSimpleName());
//    }

//    define destroy method
//    @PreDestroy
//    public void doMyDestroyStuff(){
//       System.out.println("In DoMyDestroyStuff(): "+getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";

    }
}
