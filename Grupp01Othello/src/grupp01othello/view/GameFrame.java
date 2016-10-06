package grupp01othello.view;

import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-10-04.
 */
public class GameFrame {

    private Stage primarystage;
    private BorderPane mainframe;
    private VBox options;
    private Scene mainScene;
    public Button btNewSession = new Button("Nytt Parti");
    public Button btExit = new Button("Avsluta");
    Label head = new Label("GRAND OTHELLO");

    /**
     * Konstruktorn initialiserar värden på de privata attributen.
     * @param primaryStage 
     */
    public GameFrame(Stage primaryStage) {
        this.primarystage = primaryStage;
        mainframe = new BorderPane();
        options = new VBox(10);
        mainScene = new Scene(mainframe, 800, 800);
    }
    
    
    /**
     * Skapar huvud pane som skall vara igån vid hela programmets exkevering.
     */
    public void InitializeMainFrame(){

        options.getChildren().addAll(btNewSession, btExit);
        options.setMinWidth(150);
        options.setAlignment(Pos.TOP_CENTER);
        
        head.setFont(Font.font("Arial", FontWeight.BOLD, 60));

        btNewSession.setMinWidth(100);
        btExit.setMinWidth(100);
        
        mainframe.setRight(options);

        primarystage.setTitle("OTHELLO");
        primarystage.setScene(mainScene);
        primarystage.show();
        
    }

    public void setFrameComponents(GridPane board){
        //mainframe.setleft(score); resultat
        mainframe.setTop(head);
        mainframe.setCenter(board);
    }
    
    
    
}
