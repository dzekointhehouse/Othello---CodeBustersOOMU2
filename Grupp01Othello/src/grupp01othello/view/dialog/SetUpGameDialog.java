/*
 * Initialiserar spelare.
 */
package grupp01othello.view.dialog;

import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextField;

/**
 *
 * @author Markus/Elvir 
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
        this.paneTextField = new VBox();
        this.buttOK = new Button("OK");
        this.paneCheckBox = new GridPane();
        this.scene = new Scene(pane, 700, 250);
        scene.getStylesheets().add("grupp01othello/view/OthelloStyle.css");
    }

    public String startUpScene() {


        pane.setId("setup");
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

        };

        chkLocalComputer.setOnAction(handler);
        chkRemoteComputer.setOnAction(handler);
        return player;
    }

    public String InfoBoxName() {

        List<String> choices = new ArrayList<>();
        choices.add("Elvir");
        choices.add("Markus");
        choices.add("Terminator");
        choices.add("Trump");
        choices.add("Hillary");
        choices.add("BB-8");
        choices.add("Minion");
        choices.add("Kalle Anka");
        choices.add("Patrik");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Elvir", choices);
        dialog.setTitle("game setup");
        dialog.setHeaderText("game setup");
        dialog.setContentText("Choose your player name:");

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
