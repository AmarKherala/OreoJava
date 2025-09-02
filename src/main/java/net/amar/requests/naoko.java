
/*
 * To prevent headache, i will only implement skmething that will get key values
 * i wont make an implementation for a method/s to parse into naoko.json
 * image links will be added manually
 */

package net.amar.requests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public class naoko {

    static Random ran = new Random();
    static String path = "src/main/res/naoko.json";

    public String randomNaokoImage() {
        try {
            String json = new String(Files.readAllBytes(Paths.get(path)));
            JSONObject obj = new JSONObject(json);
            JSONArray arr = obj.getJSONArray("naoko");
            int in = ran.nextInt(arr.length());
            return arr.get(in).toString();
        } catch (IOException e) {
            return null;
        }
    }
}
