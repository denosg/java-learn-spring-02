package com.costelas.learnspringframework.game.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependecy){
        this.someDependency = someDependecy;
        System.out.println("All dependencies are ready !");
    }

    @PostConstruct // builds the method after all the dependencies are loaded
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy // used on a method as a callback notif to signal that the instance is in the process of being removed
    public void cleanUp() {
        System.out.println("CleanUp");
    }

}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}

@ComponentScan
@Configuration
public class PrePostAnnotationsContextLauncherApp {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
