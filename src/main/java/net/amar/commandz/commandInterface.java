package net.amar.commandz;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface commandInterface {
  
    String getname();

    String getDescription();

    void executeSlash(SlashCommandInteractionEvent event);
}
