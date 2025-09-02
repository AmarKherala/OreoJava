package net.amar.listener;

import net.amar.requests.gary;
import net.amar.requests.naoko;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class message extends ListenerAdapter {

  private final gary g = new gary();
  private final naoko n = new naoko();

  @Override
  public void onMessageReceived(MessageReceivedEvent event) {
    String userMessage = event.getMessage().getContentRaw();

    if (userMessage.equalsIgnoreCase("ogary")) {
      event.getChannel().sendMessage(gary()).queue();
    }

    if (userMessage.equalsIgnoreCase("ogoober")) {
      event.getChannel().sendMessage(goober()).queue();
    }
    if (userMessage.equalsIgnoreCase("onaoko")) {
      event.getChannel().sendMessage(n.randomNaokoImage()).queue();
    }
  }

  public String gary() {
    return g.fetchGary("https://api.garythe.cat/gary");
  }

  public String goober() {
    return g.fetchGary("https://api.garythe.cat/goober");
  }
}
