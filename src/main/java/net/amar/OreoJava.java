package net.amar;

import java.util.EnumSet;

import net.amar.listener.message;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class OreoJava { 

    private static JDA jda;

    public static void main(String[] args) throws InterruptedException {
      String botToken = token.getToken();
      if (botToken.isEmpty()){
        log.warn("Failed to load bot token, breaking....");
        return;
      }
      try {
    jda = JDABuilder.createDefault(botToken)
    .setActivity(Activity.playing("I DONT KNOW WHAT TO DO WITH MY LIFE"))
    .setIdle(true)
    .enableIntents(EnumSet.allOf(GatewayIntent.class))
    .addEventListeners(
        new message()
    )
    .build();
      } catch (Exception e){
        log.error("Something went wrong...couldnt build JDA instance");
    }
    if (jda==null){
        log.error("what, no jda????");
        log.error("DIE!");
        return;
    }
    jda.awaitReady();
    addCommands();
}

// feel like commands need thier own method
public static void addCommands(){
    jda.updateCommands()
    .addCommands(
        // TODO 
    ).queue(success -> log.info("Commands loaded successfully"), failuer -> log.error("Failed to load commands"));
}
}
