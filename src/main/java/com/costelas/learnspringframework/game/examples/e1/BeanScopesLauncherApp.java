package com.costelas.learnspringframework.game.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass {

}

// In the case of prototype class, we are getting a new instance of this bean
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) @Component
class PrototypeClass {

}

@ComponentScan @Configuration
public class BeanScopesLauncherApp {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApp.class)) {

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
        }
    }
}
