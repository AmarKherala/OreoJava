package net.amar.requests;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
 * Gary api implementation, i dont know how else to do it
 * the api has another "joke" key which i wont add
 * onlu added gary and goober because they both
 * have the image key set to "url" and not "joke"
 *       :D
 */

public class gary {
    private static OkHttpClient cl = new OkHttpClient();
    @SuppressWarnings("CallToPrintStackTrace")
    public String fetchGary(String url){

       Request req = new Request.Builder().url(url).build();

       try (Response res = cl.newCall(req).execute()){

      if (res.body()==null) return null;

      String json = res.body().string();

      JSONObject obj = new JSONObject(json);

      return obj.get("url").toString();
       } catch (Exception e){
        e.printStackTrace();
        return null;
       }
    }
}
