package org.robert;

import com.google.gson.Gson;
import okhttp3.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 7/10/22
 * Time: 3:45 p. m.
 */

public class CatsService {
  public static void viewCats() throws IOException {
    // Get Data of API
    OkHttpClient client = new OkHttpClient().newBuilder()
        .build();
    MediaType mediaType = MediaType.parse("text/plain");
    RequestBody body = RequestBody.create(mediaType, "");
    Request request = new Request.Builder()
        .url("https://api.thecatapi.com/v1/images/search")
        .method("GET", body)
        .build();
    Response response = client.newCall(request).execute();

    String ejson = response.body().string();

    // cuts brackets
    ejson = ejson.substring(1,ejson.length());
    ejson = ejson.substring(0,ejson.length() -1);

    // Alter method
    /*
    elJson = elJson.substring(1, elJson.length()-1)
    */

    // create Object of class Gson
    Gson gson = new Gson();
    Cats cats = gson.fromJson(ejson, Cats.class);

    // Scale image
    Image image = null;
    try{
      URL url = new URL(cats.getUrl());
      image = ImageIO.read(url);

      ImageIcon fontCat = new ImageIcon(image);

      if(fontCat.getIconWidth() > 800){
        // Scale
        Image font = fontCat.getImage();
        Image changed = font.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        fontCat = new ImageIcon(changed);
      }

    }catch(IOException e){
        System.out.println(e);
    }

  }
}
