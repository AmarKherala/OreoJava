package net.amar.listener;

import net.amar.requests.gary;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class message extends ListenerAdapter{

    private static final gary g = new gary();

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
     String userMessage = event.getMessage().getContentRaw();
    
     if(userMessage.equalsIgnoreCase("ogary")){
        event.getChannel().sendMessage(gary()).queue();
     } 

     if(userMessage.equalsIgnoreCase("ogoober")){
        event.getChannel().sendMessage(goober()).queue();
     }
    
   }
   public String gary(){
 return g.fetchGary("https://api.garythe.cat/gary");
   }
   public String goober(){
 return g.fetchGary("https://api.garythe.cat/goober");
   }
}
