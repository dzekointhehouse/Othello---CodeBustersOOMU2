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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import static javafx.scene.input.KeyCode.ENTER;

/**
 *
 * @author Markus
 */
public class SetUpGameDialog {

    int i;
    private String names, player;
    private Stage setUpStage;
    private BorderPane pane;
    private VBox paneComboBox;
    private VBox paneTextField;
    private GridPane paneCheckBox;
    private Scene scene;
    private Button buttOK;

    public SetUpGameDialog() {

        setUpStage = new Stage();
        this.pane = new BorderPane();
//        this.paneComboBox = new VBox();
        this.paneTextField = new VBox();
        this.buttOK = new Button("OK");
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
        names = setTextField();
        player = setCheckBox();
        setButton();
        setUpStage.setTitle("OthelloGame");
        setUpStage.setScene(scene);
        setUpStage.showAndWait();
        return player;
    }

    public String setTextField() {
        String name;
        TextField text = new TextField();
        TextField text2 = new TextField();
        paneTextField.getChildren().addAll(text, text2);
        paneTextField.setSpacing(15);
        pane.setCenter(paneTextField);

        //text.setOnAction(e -> );
        name = text.getText();
        System.out.println("" + name);
        return name;
    }

    public void setButton() {

        pane.setBottom(buttOK);
        buttOK.setOnAction(e -> {

        });

    }

    /**
     * setComboBox används för att bestämma namnet på spelaren
     *
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
     * setCheckBox() används för att bestämma vilken typ av spelare som ska
     * användas HumanPlayer,LocalComputerPlayer eller RemoteComputerPlayer
     *
     * @return returnerar typ av spelare
     */
    public String setCheckBox() {

        CheckBox chkLocalComputer = new CheckBox("Local");
        CheckBox chkRemoteComputer = new CheckBox("Remote");

        CheckBox chkLocalComputerPlayer2 = new CheckBox("Local");
        CheckBox chkRemoteComputerPlayer2 = new CheckBox("Remote");

        paneCheckBox.addRow(1, chkLocalComputer, chkRemoteComputer);
        paneCheckBox.addRow(2, chkLocalComputerPlayer2, chkRemoteComputerPlayer2);
        paneCheckBox.setVgap(15);
        pane.setRight(paneCheckBox);
        // Handle CheckBox event.
        EventHandler<ActionEvent> handler = e -> {
            if (chkLocalComputer.isSelected()) {
                player = "Local";
                System.out.println("LocalComputer");
            } else if (chkRemoteComputer.isSelected()) {
                player = "Remote";
                System.out.println("RemoteComputer");
            } else {
                System.out.println("HumanPlayer");
            }
            //chkRemoteComputerPlayer2 chkLocalComputerPlayer2 chkHumanPlayer2

        };

        chkLocalComputer.setOnAction(handler);
        chkRemoteComputer.setOnAction(handler);
        return player;
    }

    public String InfoBoxName() {
        List<String> choices = new ArrayList<>();
        choices.add("Elvir");
        choices.add("Markus");
        choices.add("August");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Elvir", choices);
        dialog.setTitle("game setup");
        dialog.setHeaderText("game setup");
        dialog.setContentText("Choose your playerName:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Your choice: " + result.get());
        }
        return result.get();
    }
    
    public String InfoBoxTypePlayer() {
        List<String> choices = new ArrayList<>();
        choices.add("Human");
        choices.add("LocalComputerPlayer");
        choices.add("RemoteComputerPlayer");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Human", choices);
        dialog.setTitle("game setup");
        dialog.setHeaderText("game setup");
        dialog.setContentText("Choose your playerType:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Your choice: " + result.get());
        }
        return result.get();
    }
}
