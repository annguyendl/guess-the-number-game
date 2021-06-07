package com.annguyendl.console;

import com.annguyendl.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    //private static final Logger log = LoggerFactory.getLogger(Main.class);

    // For using XML annotatio  n config
    //private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.debug("Guess The Number Game");

        // Create context (container)
        // For using XML annotation config
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        // Using configuration class
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        // create numberGenerator bean from context (container)
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//
//        // call method to get random number
//        int number = numberGenerator.next();
//        log.debug("random number={}", number);
//
//        // create game bean from context (container)
//        Game game = context.getBean(Game.class);
//
//        // create messageGenerator bean from context (container)
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.debug("getMainMessage= {}", messageGenerator.getMainMessage());
//        log.debug("getResultMessage= {}", messageGenerator.getResultMessage());

        // close context (container)
        context.close();
    }
}
