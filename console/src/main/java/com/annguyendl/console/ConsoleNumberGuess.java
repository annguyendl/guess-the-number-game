package com.annguyendl.console;

import com.annguyendl.Game;
import com.annguyendl.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

@Component
//public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
public class ConsoleNumberGuess {
    //== constants ==
    public static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //== fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        log.debug("Container is ready to use.");
//    }


    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.debug("start() -> Container is ready to use.");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (!game.isValidNumber()) {
                System.out.println("Invalid number range!");
            }

            if (game.isGameLost() || game.isGameWon()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again [y/n]?");

                String playAgain = scanner.nextLine().trim();
                if (!playAgain.toLowerCase(Locale.ROOT).contains("y")) {
                    break;
                }
                game.reset();
            }
        }
    }
}
