package com.costelas.learnspringframework.game;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration("SuperContraGame")
public class SuperContraGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("up");
    }
    @Override
    public void down() {
        System.out.println("Sit down");
    }
    @Override
    public void left() {
        System.out.println("Go back");
    }
    @Override
    public void right() {
        System.out.println("Shoot a bullet");
    }
}
