package net.amar.commandz.infoz;

import net.amar.commandz.commandInterface;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class botinfo implements commandInterface {

	@Override
	public String getname() {
		return "botinfo";
	}

	@Override
	public String getDescription() {
		return "info about the bot";
	}

	@Override
	public void executeSlash(SlashCommandInteractionEvent event) {
	// enough with the fancy embeds ugh..they became boring :(
        event.reply("HI, Its oreo.java speaking.\n- Bot repository : \n you can look through my source code and information [here](https://github.com/AmarKherala/OreoJava)");

	}
    
}
