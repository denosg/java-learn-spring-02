package com.costelas.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MarioGame")
public class MarioGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("Jump");
    }
    @Override
    public void down() {
        System.out.println("Go into a hole");
    }
    @Override
    public void left() {
        System.out.println("Go back");
    }
    @Override
    public void right() {
        System.out.println("Accelerate");
    }
}
