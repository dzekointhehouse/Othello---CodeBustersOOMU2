package grupp01othello.view;

import grupp01othello.controller.ExitHandler;
import grupp01othello.controller.NewGameHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//exit
/**
 * Created by optimusprime (Elvir) on 2016-10-04.
 */
public class GameFrame {

    private Stage primarystage;
    private BorderPane mainframe;
    private VBox optionBox;
    private HBox infoBox;
    private VBox scoreBox;
    private TextArea txtScore;
    private StackPane topPane;
    private Scene scene;
    private Button btNewSession;
    private Button btExit;
    private Label lblHeader;
    private Label playerinfo;
    private Background background;

    private int minWidth = 800, minHeight = 650;

    /* Konstruktorn initialiserar attributerna vid skapande av gameFrame */
    public GameFrame(Stage primaryStage) {

        this.btNewSession = new Button("Nytt Parti");
        this.btExit = new Button("Avsluta");
        this.primarystage = primaryStage;
        this.mainframe = new BorderPane();
        this.optionBox = new VBox(10);
        this.infoBox = new HBox(15);
        this.topPane = new StackPane();
        this.scene = new Scene(mainframe, minWidth, minHeight);
        this.txtScore = new TextArea();
        this.playerinfo = new Label();
        this.scoreBox = new VBox(playerinfo, txtScore);

        this.lblHeader = new Label("OTHELLO");
        newGameButton();
        ExitButton();
        scene.getStylesheets().add("grupp01othello/view/OthelloStyle.css");
    }

    /**
     * Skapar huvud pane som skall vara igån vid hela programmets exkevering.
     */
    public void showFrame() {

        background = new Background(new BackgroundImage(
                new Image("image/othello3.jpg"),
                BackgroundRepeat.SPACE,
                BackgroundRepeat.SPACE,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)));

        mainframe.setBackground(background);

        primarystage.setMinHeight(minHeight);
        primarystage.setMinWidth(minWidth);
        primarystage.setTitle("CodeBusters");
        primarystage.setScene(scene);
        primarystage.show();

    }

    public void setAllComponents(GridPane board) {
        setOptionsComponent();
        setHeaderComponent();
        setScoreComponent();
        mainframe.setCenter(board);
        setInformationComponent();
    }

    private void setScoreComponent() {
        scoreBox.setMaxWidth(200);
        scoreBox.setPadding(new Insets(15));
        scoreBox.layoutXProperty().bindBidirectional(mainframe.layoutXProperty());
        scoreBox.setAlignment(Pos.CENTER);
        txtScore.setStyle("-fx-text-fill: black;");
        txtScore.setEditable(false);
        txtScore.opacityProperty().set(20);
        mainframe.setLeft(scoreBox);
    }

    private void setOptionsComponent() {
        optionBox.getChildren().addAll(btNewSession, btExit);
        optionBox.setMinWidth(150);
        optionBox.setAlignment(Pos.TOP_CENTER);
        btNewSession.setMinWidth(100);
        btExit.setMinWidth(100);
        mainframe.setRight(optionBox);
    }

    /**
     * Sätter in header komponenten som består av spelets namn.
     */
    private void setHeaderComponent() {

        lblHeader.setFont(Font.font("Arial", FontWeight.BOLD, 60));
        lblHeader.setStyle("-fx-text-fill: rgba(114,131,148,0.9);" + "-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 2 );");
        lblHeader.setAlignment(Pos.CENTER);
        topPane.getChildren().add(lblHeader);
        topPane.setAlignment(Pos.CENTER);
        mainframe.setTop(topPane);
    }

    /**
     * Sätter in den högra komponenten i frame.
     */
    private void setInformationComponent() {
        infoBox.setMinHeight(20);
        mainframe.setBottom(infoBox);
    }

    /**
     * Anropar ExitHandler som stänger ner programmet.
     */
    private void ExitButton() {
        btExit.setOnAction(e -> {
            ExitHandler exit = new ExitHandler();
            exit.handle(e);
        });
    }

    private void newGameButton() {
        btNewSession.setOnAction(e -> {

            NewGameHandler newGame = new NewGameHandler(primarystage);
            newGame.handle(e);
        });

    }

    public void updateScore(String scoreString) {
        txtScore.setText(scoreString);
    }

    public void setPlayerInfo(String player1, String player2) {
        playerinfo.setId("playerinfo");
        playerinfo.setText(player1 + "\n vs \n" + player2);
    }

}
