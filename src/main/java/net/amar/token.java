package net.amar;

import io.github.cdimascio.dotenv.*;

public class token {
    private static final Dotenv load = Dotenv.configure().directory("src/main/res").load();

    public static String getToken(){
        return load.get("BOT_TOKEN");
    }
}
