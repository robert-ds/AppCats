package org.robert;

import javax.swing.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 7/10/22
 * Time: 3:08 p. m.
 */

public class Main {

  public static void main(String[] args) throws IOException {

    int opt = -1;
    String[] botones = {
        "1. View Cats","2. Exit"
    };

    do{

      String option =  (String) JOptionPane.showInputDialog(null,"Cats Java","Main Menu", JOptionPane.INFORMATION_MESSAGE, null, botones,botones[0]);

      // Validate option  selected for user
      for(int i = 0;i < botones.length; i++){
        if(option.equals(botones[i])){
          opt = i;
        }
      }

      switch(opt){
        case 0:
          CatsService.viewCats();
          break;

        default:
          break;
      }

    }while(opt != 1);


  }

}
