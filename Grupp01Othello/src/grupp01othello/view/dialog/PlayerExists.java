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
public class PlayerExists {

    public PlayerExists() {
        PlayerExistsAlert();
    }
/**
 * Aleart dialog som säger till användaren att han har matat in 2 likadana namn vilket inte är OK!
 */
    public void PlayerExistsAlert() {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Startup information");
        alert.setHeaderText("Playername Error!");
        alert.setContentText("You have already created a player with this name!");
        alert.showAndWait();
    }
}
