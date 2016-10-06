package grupp01othello.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-10-04.
 */
public class GameFrame {

    private Stage primarystage;
    private BorderPane mainframe;
    private VBox options;
    private Scene mainScene;

    public GameFrame(Stage primaryStage) {
        this.primarystage = primaryStage;
        mainframe = new BorderPane();
        options = new VBox(10);
        mainScene = new Scene(mainframe, 800, 800);
    }

    public void startFrame(){

        Button btNewSession = new Button("Nytt Parti");
        Button btExit = new Button("Avsluta");

        options.getChildren().addAll(btNewSession, btExit);
        mainframe.setRight(options);

        primarystage.setTitle("OTHELLO");
        primarystage.setScene(mainScene);
        primarystage.show();
    }

    public void setBoard(GridPane board){
        mainframe.setCenter(board);
    }
}
