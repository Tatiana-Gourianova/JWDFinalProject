package com.gourianova.binocularvision;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.gourianova.binocularvision")
@PropertySource("classpath:AppTrainer.properties")
public class SpringConfig {
    @Bean
    public PlatformerBinocularvisionApp platformerBinocularvisionApp(){
         return new PlatformerBinocularvisionApp();
    }

    @Bean
    public QuestBinocularvisionApp questBinocularvisionApp(){
        return new QuestBinocularvisionApp();
    }
    @Bean
    public AppTrainer appTrainer(){
        return new AppTrainer(platformerBinocularvisionApp(),questBinocularvisionApp());
    }

@Bean
    public Email email(){
        return new Email(appTrainer() );
}


}
