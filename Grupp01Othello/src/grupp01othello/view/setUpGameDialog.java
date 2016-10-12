/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view;

import java.util.Optional;
import javafx.scene.control.TextInputDialog;
/**
 *
 * @author Markus
 */
public class setUpGameDialog {

   
   setUpGameDialog() {
        /* By specifying a null headerMessage String, we cause the dialog to
           not have a header */
        infoBox();
    }

    public static String infoBox() {
        String player;
    TextInputDialog dialog = new TextInputDialog("Player");
        dialog.setTitle("Which Player?");
        dialog.setHeaderText("Start OthelloGame");
        dialog.setContentText("Please enter PlayerType: Human, local or remote ");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println(" Player is: " + result.get());
        }
        player = result.get();
    return player;
}
}
