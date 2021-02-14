package com.gourianova.binocularvision;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")

public class QuestBinocularvisionApp implements BinocularvisionApp {
  //  private String author;
   // public QuestBinocularvisionApp(String author){
    //    this.author=author;
    //}
    //public String getAuthor(){
      //  return author;
    //}


      @PostConstruct
      public void doMynit(){
          System.out.println(("Initialization of Quest"));}

      //@PreDestroy
      public void doMyDestroy(){
          System.out.println("Destruction of Platformer");
      }

    @Override
    public String getBinocularvisionApp() {
        return "Find the way";
    }
}
