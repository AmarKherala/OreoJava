package net.amar.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class message extends ListenerAdapter{
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
if (event.getMessage().getContentRaw().equals("oreo")){
    event.getChannel().sendMessage("HI!").queue();
      }
   }
}
