package com.costelas.learnspringframework.game.examples.h1;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@ComponentScan
@Configuration
public class XMLConfigContextLauncherApp {

    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("contextConfig.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
        }
    }
}
