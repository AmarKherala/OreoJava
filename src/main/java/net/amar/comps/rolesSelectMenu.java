package net.amar.comps;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class rolesSelectMenu {
    public StringSelectMenu colorMenu(){
     return StringSelectMenu.create("roles")
     .setPlaceholder("pick a color")
     .addOption("Light Blue","1307766379234988153", Emoji.fromUnicode("🟦"))
     .addOption("ORANGE", "1308846283766894624", Emoji.fromUnicode("🟧"))
     .addOption("Black", "1309075735272488960", Emoji.fromUnicode("⬛"))
     .addOption("YELLOW", "1306218380306681916", Emoji.fromUnicode("🟨"))
     .addOption("GREEN", "1405197124806643782", Emoji.fromUnicode("🟩"))
     .addOption("RED", "1307016237326401569", Emoji.fromUnicode("🟥"))
     .addOption("PURPLE", "1401951980611702925", Emoji.fromUnicode("🟪"))
     .addOption("PINK", "1305880394335522887", Emoji.fromUnicode("💓"))
     .addOption("CATGIRL", "1307366663133597726", Emoji.fromUnicode("🐱"))
     .addOption("REMOVE", "remove", Emoji.fromUnicode("❌"))
     .setRequiredRange(0, 1)
     .build();
    }
}
