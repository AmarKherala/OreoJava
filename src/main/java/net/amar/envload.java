package net.amar;

import io.github.cdimascio.dotenv.Dotenv;

public class envload {
    private static final Dotenv load = Dotenv.configure().directory("src/main/res").load();

    public static String getToken(){
        return load.get("BOT_TOKEN");
    }

    public static String getPrefix(){
        return load.get("PREFIX");
    }
}
