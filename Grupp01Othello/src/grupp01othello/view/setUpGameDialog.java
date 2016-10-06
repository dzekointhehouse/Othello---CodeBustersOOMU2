/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
/**
 *
 * @author Markus
 */
public class setUpGameDialog {

    public static void infoBox(String infoMessage, String titleBar)
    {
        /* By specifying a null headerMessage String, we cause the dialog to
           not have a header */
        infoBox();
    }

    public static void infoBox()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Val Av spelare");
        alert.setHeaderText("Othello");
        alert.setContentText("Vad heter spelaren?");
        alert.showAndWait();
    }
}
