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
		event.reply(
				"Hi, Its oreo.java speaking.\n everything you need to know about me is here:\n- [Bot repository](https://github.com/AmarKherala/OreoJava)")
				.queue();

	}

}
