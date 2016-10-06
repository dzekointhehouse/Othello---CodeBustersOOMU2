import grupp01othello.controller.GameManager;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.RadialGradient;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GameManager othello = new GameManager(primaryStage);
        othello.setupGameBoard();
    }

    public static void main(String[] args){
        launch(args);
    }
}
