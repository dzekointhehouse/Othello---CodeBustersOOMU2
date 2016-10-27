/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view.dialog;

import javafx.scene.control.Alert;

/**
 *
 * @author Markus
 */
public class DrawDialog {
    
   public DrawDialog() {
       

    }
   /**
    * drawBox en dialog som informerar att matchen har slutat lika "draw"
    */
   public void drawBox(){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("I have a message for you!\n");
        alert.setContentText("its a DRAW");

        alert.showAndWait();
 
   
   }
}
