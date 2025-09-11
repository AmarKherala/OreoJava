package net.amar.listener;

import java.awt.Color;
import java.time.OffsetDateTime;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class joinsleaves extends ListenerAdapter {
  
  private final long wc = 1307399596074467389L;
  
  @Override
  public void onGuildMemberJoin(@SuppressWarnings("null") GuildMemberJoinEvent event){
    try {
    Guild guild = event.getGuild();
    TextChannel welcome = guild.getTextChannelById(wc);
    Member memberJoined = event.getMember();
    
    EmbedBuilder em = new EmbedBuilder();
    em.setTitle("Member Joined :D!");
    em.setThumbnail(memberJoined.getUser().getAvatarUrl());
    em.setDescription("Welcome " + memberJoined.getAsMention() + " To Oreos Bar!");
    em.setColor(Color. GREEN);
    em.setTimestamp(memberJoined.getTimeJoined());
    welcome.sendMessageEmbeds(em.build()).queue();
  } catch (Exception e){
    e.printStackTrace();
  }
 }   
  @Override
  public void onGuildMemberRemove(@SuppressWarnings("null") GuildMemberRemoveEvent event){
    try {
    Guild guild = event.getGuild();
    TextChannel welcome = guild.getTextChannelById(wc);
    User memberLeft = event.getUser();
    
    EmbedBuilder em = new EmbedBuilder();
    em.setTitle("Member Left D:!");
    em.setThumbnail(memberLeft.getAvatarUrl());
    em.setDescription("Bye " + memberLeft.getAsMention() + " we will miss you :(");
    em.setColor(Color.RED);
    em.setTimestamp(OffsetDateTime.now());
    welcome.sendMessageEmbeds(em.build()).queue();
  } catch (Exception a) {
    a.printStackTrace();
   }
  }
}