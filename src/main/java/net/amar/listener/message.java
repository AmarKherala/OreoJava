package net.amar.listener;

import java.awt.Color;
import java.time.OffsetDateTime;

import net.amar.comps.rolesSelectMenu;
import net.amar.envload;
import net.amar.log;
import net.amar.requests.gary;
import net.amar.requests.naoko;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class message extends ListenerAdapter {

  private final gary g = new gary();
  private final naoko n = new naoko();
  private final String prefix = envload.getPrefix();
  private final String onwerID = envload.ownerID();
  private final rolesSelectMenu menu = new rolesSelectMenu();

  @Override
  public void onMessageReceived(MessageReceivedEvent event) {

    if(event.getAuthor().isBot()) return;

    String userMessage = event.getMessage().getContentRaw();

    if (userMessage.equalsIgnoreCase(prefix + "gary")) {
      event.getChannel().sendMessage(gary()).queue();
    }

    if (userMessage.equalsIgnoreCase(prefix + "goober")) {
      event.getChannel().sendMessage(goober()).queue();
    }
    if (userMessage.equalsIgnoreCase(prefix + "naoko")) {
      event.getChannel().sendMessage(n.randomNaokoImage()).queue();
    }
    if (userMessage.equals(prefix+"send-roles-menu") && event.getAuthor().getId().equals(onwerID)) {
      sendRolesMenuEmbed(event);
    }
  }

  public String gary() {
    return g.fetchGary("https://api.garythe.cat/gary");
  }

  public String goober() {
    return g.fetchGary("https://api.garythe.cat/goober");
  }
  
  public void sendRolesMenuEmbed(MessageReceivedEvent event) {
    EmbedBuilder em = new EmbedBuilder();
    em.setTitle("Color roles!");
    em.setDescription("Select the color you like by clicking the button bellow.");
    em.setColor(Color.BLUE);
    em.setTimestamp(OffsetDateTime.now());
    try {
    event.getChannel().sendMessageEmbeds(em.build()).addActionRow(menu.colorMenu()).queue();
  } catch (IllegalArgumentException e){
    log.error("Failed to send message");
    log.info("Maybe embed componets are empty?");
  }
 }
}