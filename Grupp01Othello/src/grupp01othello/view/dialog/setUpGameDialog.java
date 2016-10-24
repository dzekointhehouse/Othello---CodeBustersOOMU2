/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view.dialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
/**
 *
 * @author Markus
 */
public class setUpGameDialog {

   
  public setUpGameDialog() {
        /* By specifying a null headerMessage String, we cause the dialog to
           not have a header */
    }

    public String infoBox() {
        String player;
        List<String> choices = new ArrayList<>();
        choices.add("HumanPlayer");
        choices.add("LocalComputerPlayer");
        choices.add("RemoteComputerPlayer");
        
        ChoiceDialog<String> dialog = new ChoiceDialog<>("HumanPlayer", choices);
        dialog.setTitle("Which Player?");
        dialog.setHeaderText("Start OthelloGame");
        dialog.setContentText("Please Choose your player ");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Player is: " + result.get());
        }
        player = result.get();
        
    return player;
}

   public String infoBoxName() {
        String name;
    TextInputDialog dialog = new TextInputDialog("Player");
        dialog.setTitle("what is the name for Player?");
        dialog.setHeaderText("Start OthelloGame");
        dialog.setContentText("Please enter name for player");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println(" Player is: " + result.get());
        }
        name = result.get();
        
    return name;
}
}