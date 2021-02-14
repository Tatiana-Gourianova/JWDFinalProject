package com.gourianova.binocularvision;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//@Scope("prototype")
public class PlatformerBinocularvisionApp implements BinocularvisionApp {

 @PostConstruct
    public void doMynit(){
        System.out.println(("Initialization of Platformer"));}

    //@PreDestroy
   public void doMyDestroy(){
      System.out.println("Destruction of Platformer");
    }


    @Override
    public String getBinocularvisionApp() {
        return "10-levels platformer";
    }
}
