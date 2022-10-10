package org.robert;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 10/10/22
 * Time: 4:27 p. m.
 */

public class CatsFav {

  String id;
  String image_id;
  String apiKey = "live_0vvEexCIZoQNDvTpVFC26CV2JhF0X1CQ8iN3LDkBRdH2ymKUcKiHrY9s6F9YwIhf";
  Imagex image;

  // Getters and Setters

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getImage_id() {
    return image_id;
  }

  public void setImage_id(String image_id) {
    this.image_id = image_id;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public Imagex getImage() {
    return image;
  }

  public void setImage(Imagex image) {
    this.image = image;
  }

}
