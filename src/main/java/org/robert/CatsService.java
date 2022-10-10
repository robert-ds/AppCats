package org.robert;

import com.google.gson.Gson;
import com.squareup.okhttp.*;

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
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();

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
        Image changed = font.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
        fontCat = new ImageIcon(changed);
      }

      // Create menu for app
      String menu = "Options:\n"
          + "1. View New Image\n"
          + "2. Favourite\n"
          + "3. return\n";

      String[] botones = {"See another image","Favourite", "return"};
      String id_cat = cats.getId();
      String option = (String) JOptionPane.showInputDialog(null,menu,id_cat, JOptionPane.INFORMATION_MESSAGE, fontCat, botones,botones[0]);

      int selected = -1;

      // validate option of user
      for(int i = 0;i < botones.length; i++){
        if(option.equals(botones[i])){
          selected = i;
        }
      }

      switch(selected){
        case 0:
          viewCats();
          break;
        case 1:
          FavouriteCat(cats);
          break;
        default:
          break;
      }

    }catch(IOException e){
        System.out.println(e);
    }

  }

  public static void FavouriteCat(Cats cat){

    try{
      OkHttpClient client = new OkHttpClient();
      MediaType mediaType = MediaType.parse("application/json");
      RequestBody body = RequestBody.create(mediaType, "{\n\t\"image_id\":\""+ cat.getId() +"\"\n}");
      Request request = new Request.Builder()
          .url("https://api.thecatapi.com/v1/favourites")
          .post(body)
          .addHeader("Content-Type", "application/json")
          .addHeader("x-api-key", cat.getApikey())
          .build();
      Response response = client.newCall(request).execute();
    }catch(IOException e){
      System.out.println(e);
    }

  }

}
