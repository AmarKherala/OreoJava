package net.amar.commandz.infoz;

import java.awt.Color;
import java.time.LocalDate;

import net.amar.commandz.commandInterface;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class serverinfo implements commandInterface {
    
    @Override
    public String getname() {
        return "serverinfo";
    }

    @Override
    public String getDescription() {
        return "get info about server";
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void executeSlash(SlashCommandInteractionEvent event) {
        EmbedBuilder em = new EmbedBuilder();
        try {
        // ih my god this looks awful
         User u = event.getUser();
         Guild g = event.getGuild();
         String name = g.getName();
         Member owner = g.getOwner();
         String id = g.getId();
         long members = g.getMemberCount();
         String icon = g.getIconUrl();
         LocalDate created = g.getTimeCreated().toLocalDate();

         // building embed
         em.setTitle("Information about : %s",name);
         em.setDescription("## Server owner: " +owner+ "\n ## Server ID:" + id + "\n ## Server creation date: "+created+" \n ## Server member count: " + members);
         em.setThumbnail(icon);
         em.setFooter("Requested by: " + u.getName(), u.getAvatarUrl());
         em.setColor(Color.BLUE);

         event.replyEmbeds(em.build()).queue();

        } catch (NullPointerException a){
         event.reply("Are you sure this is a server?").queue();
        }
        catch (Exception e){
        e.printStackTrace();
        }
    }
    
}
