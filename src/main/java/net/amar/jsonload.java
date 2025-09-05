package net.amar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

public class jsonload {
    public String orange;
    public String yellow;
    public String black;
    public String red;
    public String purple;
    public String pink;
    public String lightblue;
    public String green;
    public String catgirl;

    public void readFile() {
        try {
            String jsonText = new String(Files.readAllBytes(Paths.get("src/main/res/config/server.json")));
            JSONObject obj = new JSONObject(jsonText);

            orange    = obj.optString("ID_orange", null);
            yellow    = obj.optString("ID_yellow", null);
            black     = obj.optString("ID_black", null);
            red       = obj.optString("ID_red", null);
            purple    = obj.optString("ID_purple", null);
            pink      = obj.optString("ID_pink", null);
            lightblue = obj.optString("ID_lightblu", null);
            green     = obj.optString("ID_green", null);
            catgirl   = obj.optString("ID_catgirl", null);

        } catch (IOException e) {
            log.error("Couldn't read/find file server.json");
            log.info("Check src/main/res/config/server.json.example for more information");
        } catch (JSONException e) {
            log.error("Invalid JSON in server.json");
        }
    }
}
