package net.amar.commandz.moderation;

import net.amar.commandz.commandInterface;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
public class kick implements commandInterface {

    @Override
    public String getname() {
        return "kick";
    }

    @Override
    public String getDescription() {
        return "kick a bad guy";
    }

    @Override
    public void executeSlash(SlashCommandInteractionEvent event) {
       Member m = event.getOption("user").getAsMember();
       String reason = event.getOption("reason").getAsString();
       Guild g = event.getGuild();
       TextChannel ch = g.getTextChannelById(1419537636711993476L);
       User u = m.getUser();
       u.openPrivateChannel().queue(ptv -> ptv.sendMessage("You got kicked from oreos bar..\nBy : "+event.getUser().getAsMention()+"\nFor reason : "+reason));
       ch.sendMessage("Kicked member: "+m.getAsMention()+"\nFor reason: "+reason+"\nBy: "+event.getUser().getAsMention()).queue();
       g.kick(m).queue();
       event.reply("kicked!").queue();
    }
}
