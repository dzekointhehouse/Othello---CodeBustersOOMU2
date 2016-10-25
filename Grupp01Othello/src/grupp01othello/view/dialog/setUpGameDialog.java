/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view.dialog;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import grupp01othello.controller.PlayerFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;

/**
 *
 * @author Markus
 */
public class setUpGameDialog {

    int i;
    private String names, player;
    private Stage setUpStage;
    private BorderPane pane;
    private VBox paneComboBox;
    private GridPane paneCheckBox;
    private Scene scene;

    public setUpGameDialog() {
        setUpStage = new Stage();
        this.pane = new BorderPane();
        this.paneComboBox = new VBox();
        this.paneCheckBox = new GridPane();
        this.scene = new Scene(pane, 700, 250);
    }

    public String startUpScene() {

        Background background = new Background(new BackgroundImage(
                new Image("image/java.png"),
                BackgroundRepeat.SPACE,
                BackgroundRepeat.SPACE,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT));

        pane.setBackground(background);
        //setComboBox();
       player = setCheckBox();
        setUpStage.setTitle("OthelloGame");
        setUpStage.setScene(scene);
        setUpStage.showAndWait();
        return player;
    }
/**
 * setComboBox används för att bestämma namnet på spelaren
 * @return returnerar vilket namn som valdes 
 */ 

    public String setComboBox() {
        ObservableList<String> name;
        name = FXCollections.observableArrayList("Markus", "Elvir ", "August");

        ComboBox comboBox = new ComboBox(name);
        ComboBox comboBoxPlayer2 = new ComboBox(name);
        paneComboBox.setSpacing(15);
        paneComboBox.getChildren().addAll(comboBox, comboBoxPlayer2);
        pane.setCenter(paneComboBox);
        name.indexOf(name);
        return name.get(i);
    }
    /** 
     * setCheckBox() används för att bestämma vilken typ av spelare som ska användas
     * HumanPlayer,LocalComputerPlayer eller RemoteComputerPlayer
     * @return returnerar typ av spelare 
     */
    public String setCheckBox() {

        CheckBox chkHuman = new CheckBox("Human");
        CheckBox chkLocalComputer = new CheckBox("Local");
        CheckBox chkRemoteComputer = new CheckBox("Remote");
        CheckBox chkHumanPlayer2 = new CheckBox("Human");
        CheckBox chkLocalComputerPlayer2 = new CheckBox("Local");
        CheckBox chkRemoteComputerPlayer2 = new CheckBox("Remote");

        paneCheckBox.addRow(1, chkHuman, chkLocalComputer, chkRemoteComputer);
        paneCheckBox.addRow(2, chkHumanPlayer2, chkLocalComputerPlayer2, chkRemoteComputerPlayer2);
        paneCheckBox.setVgap(15);
        pane.setRight(paneCheckBox);
        // Handle CheckBox event.
        EventHandler<ActionEvent> handler = e -> {
            if (chkHuman.isSelected()) {
                player = "Human";
                System.out.println("HumnanPlayer");
            } else if (chkLocalComputer.isSelected()) {
                player = "Local";
                System.out.println("LocalComputer");
            } else if (chkRemoteComputer.isSelected()) {
                player = "Remote";
                System.out.println("RemoteComputer");
            } else {
                System.out.println("vrf gör du fel???");
            }
            //chkRemoteComputerPlayer2 chkLocalComputerPlayer2 chkHumanPlayer2

        };

        chkHuman.setOnAction(handler);
        chkLocalComputer.setOnAction(handler);
        chkRemoteComputer.setOnAction(handler);
        return player;
    }
}
