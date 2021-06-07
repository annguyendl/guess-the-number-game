package com.annguyendl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
//    //== constants ==
//    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    //== fields ==
    private final Game game;

    //== construction ==
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    //== init ==
    @PostConstruct
    void init() {
        log.debug("game = {}", game);
    }

    //== public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() + " and " +
                game.getBiggest() + ". Can you guess again?";
    }

    @Override
    public String getResultMessage() {
        String message;
        if (game.isGameWon()) {
            message = "You won. The number was " + game.getNumber() + ".";
        } else if (game.isGameLost()) {
            message = "You lost. The number was " + game.getNumber() + ".";
        } else if (game.getRemainGuesses() == game.getGuessCount()) {
            message = "What is the first time?";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }

            message = direction + "! You have " +
                    game.getRemainGuesses() + " guesses left.";
        }
        return message;
    }
}