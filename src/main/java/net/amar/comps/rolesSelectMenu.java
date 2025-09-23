package net.amar.comps;

import net.amar.jsonload;
import net.amar.log;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class rolesSelectMenu {

    private final jsonload load = new jsonload();

    public StringSelectMenu colorMenu(){
        load.readFile();
        try {
     StringSelectMenu.Builder menu = StringSelectMenu.create("roles")
     .setPlaceholder("pick a color")
     .setRequiredRange(0, 1);
     safeAdd(menu, "ORANGE",load.orange,"🟧");
     safeAdd(menu, "BLACK", load.black, "⬛");
     safeAdd(menu, "RED", load.red, "🟥");
     safeAdd(menu, "YELLOW", load.yellow, "🟨");
     safeAdd(menu, "PURPLE", load.purple, "🟪");
     safeAdd(menu, "LIGHTBLUE", load.lightblue, "🟦");
     safeAdd(menu, "PINK", load.pink, "💓");
     safeAdd(menu, "GREEN", load.green, "🟩");
     safeAdd(menu, "CATGIRL", load.catgirl, "🐱");
     safeAdd(menu, "BLUE", load.blue, "💙");
     menu.addOption("REMOVE", "removeMyFuckingRoles", Emoji.fromUnicode("❌"));
     return menu.build();
            }
            catch (IllegalArgumentException a){
            log.error("Some other values are empty or cant be detected");
            return null;
            }
            catch (Exception e){
            log.error("Something went totally wrong");
            log.warn("Make sure server.json at res/config is configured properly");
            return null;
        }
    }
    @SuppressWarnings("null")
    private void safeAdd(StringSelectMenu.Builder menu, String label, String value, String emoji){
        if(!(value==null && value.isBlank())){
            try {
       menu.addOption(label, value, Emoji.fromUnicode(emoji));
            } catch(IllegalArgumentException e){
             log.error("Skipping empty values...");
            }
       } else {
        log.info("Skipping value because its missing");
       }
    }
}
