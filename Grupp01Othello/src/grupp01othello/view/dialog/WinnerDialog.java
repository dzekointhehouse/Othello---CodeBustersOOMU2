/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view.dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Markus
 */
public class WinnerDialog {

   public WinnerDialog() {
       

    }
   public void winBox(String winner){
    Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("I have a great message for you!\n");
        alert.setContentText(winner + " WIN!");

        alert.showAndWait();
 
   
   }
}
