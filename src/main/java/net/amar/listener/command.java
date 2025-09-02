package net.amar.listener;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;

import net.amar.commandz.commandInterface;
import net.amar.commandz.infoz.serverinfo;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class command extends ListenerAdapter{

    private final Map <String , commandInterface> commands = new HashMap<>();

    public command(){
    commands.put("serverinfo", new serverinfo());
    }
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        String commandName = event.getName();
       commandInterface command = commands.get(commandName);
       command.executeSlash(event);
    }
}
