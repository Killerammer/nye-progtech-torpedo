package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.service.GameState;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("hu.nye.progtech.torpedo");
        GameState gameState = context.getBean(GameState.class);

        /**
         * Egy paranccsal elindítom a játékot.
         */

        gameState.playGame();
    }
}