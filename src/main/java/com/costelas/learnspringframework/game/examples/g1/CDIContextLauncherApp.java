package com.costelas.learnspringframework.game.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Named
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        System.out.println("Setter injection " + dataService);
        return dataService;
    }

//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
}

@Named
class DataService {

}

@ComponentScan
@Configuration
public class CDIContextLauncherApp {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(CDIContextLauncherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
