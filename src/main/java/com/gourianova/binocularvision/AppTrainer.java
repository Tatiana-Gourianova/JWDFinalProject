package com.gourianova.binocularvision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppTrainer {
    @Value("${appTrainer.name}")
    private  String name;
    @Value("${appTrainer.color}")
    private  String color;

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public  String getName() {
        return name;
    }

    public  String getColor() {
        return color;
    }


    private BinocularvisionApp binocularvisionApp1;
    private BinocularvisionApp binocularvisionApp2;

  //  @Autowired
    public AppTrainer(@Qualifier("platformerBinocularvisionApp") BinocularvisionApp binocularvisionApp1,
                    @Qualifier("questBinocularvisionApp") BinocularvisionApp binocularvisionApp2){
        this.binocularvisionApp1=binocularvisionApp1;
        this.binocularvisionApp2=binocularvisionApp2;
    }


public String runApp(){
  return "Playing: "+ binocularvisionApp1.getBinocularvisionApp()+", "+binocularvisionApp2.getBinocularvisionApp();

}

}
