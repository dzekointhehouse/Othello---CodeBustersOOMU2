package grupp01othello.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import grupp01othello.view.setUpGameDialog;
import static grupp01othello.view.setUpGameDialog.infoBox;
/**
 * Created by optimusprime on 2016-10-04.
 */
public class GameFrame {

    private Stage primarystage;
    private BorderPane mainframe;
    private VBox options;
    private HBox infoBox;
    private Scene mainScene;
    public Button btNewSession = new Button("Nytt Parti");
    public Button btExit = new Button("Avsluta");
    Label head = new Label("GRAND OTHELLO");  
    Label lblTurns;
    

    /**
     * Konstruktorn initialiserar attributerna vid skapande av gameFrame.
     * @param primaryStage 
     */
    public GameFrame(Stage primaryStage) {
        this.primarystage = primaryStage;
        this.mainframe = new BorderPane();
        this.options = new VBox(10);
        this.infoBox = new HBox(15);
        this.mainScene = new Scene(mainframe, 800, 650);     
        this.lblTurns = new Label("Turns Left");
    }
    
    
    /**
     * Skapar huvud pane som skall vara igån vid hela programmets exkevering.
     */
    public void InitializeMainFrame(){
        
        Background bgWood = new Background(new BackgroundImage(
                new Image("image/wood.jpg"), 
                BackgroundRepeat.SPACE, 
                BackgroundRepeat.SPACE, 
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT));
        
        mainframe.setBackground(bgWood);

        
        head.setFont(Font.font("Arial", FontWeight.BOLD, 60));



        primarystage.setTitle("CodeBusters");
        primarystage.setScene(mainScene);
        primarystage.show();
        infoBox();
        
    }

    public void setAllComponents(GridPane board){
        setOptionsComponent();
        setHeaderComponent();
        setScoreComponent();
        mainframe.setCenter(board);
        setInformationComponent();
    }
    
    private void setScoreComponent(){
        lblTurns.setMinWidth(100);
        lblTurns.setAlignment(Pos.CENTER);
        lblTurns.setStyle("-fx-text-fill: #FFFFFF;");
        mainframe.setLeft(lblTurns);
    }
    
    private void setOptionsComponent(){
        options.getChildren().addAll(btNewSession, btExit);
        options.setMinWidth(150);
        options.setAlignment(Pos.TOP_CENTER);
        btNewSession.setMinWidth(100);
        btExit.setMinWidth(100);
        mainframe.setRight(options);
    }
    /**
     * Kanske ta in bool som parameter för att kunna av aktivera metoden som
     * alternativ.
     */
    private void setHeaderComponent(){

        head.setFont(Font.font("Arial", FontWeight.BOLD, 60));
        head.setAlignment(Pos.CENTER);
                mainframe.setTop(head);
    }
    
    private void setInformationComponent(){
        infoBox.setMinHeight(20);
        mainframe.setBottom(infoBox);
    }
    
    
    
}
