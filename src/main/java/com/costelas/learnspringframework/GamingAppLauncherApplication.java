package com.costelas.learnspringframework;

import com.costelas.learnspringframework.game.GameRunner;
import com.costelas.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.costelas.learnspringframework.game")
public class GamingAppLauncherApplication {

    // Spring would take this name bean and wire it here (pass it as a parameter call)

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }
    }
}
