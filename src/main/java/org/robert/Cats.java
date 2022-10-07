package org.robert;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 7/10/22
 * Time: 3:10 p. m.
 */

public class Cats {

  int id;
  String url;
  String apikey = "live_0vvEexCIZoQNDvTpVFC26CV2JhF0X1CQ8iN3LDkBRdH2ymKUcKiHrY9s6F9YwIhf";
  String image;

  // Getters and Setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getApikey() {
    return apikey;
  }

  public void setApikey(String apikey) {
    this.apikey = apikey;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

}
