package grupp01othello.controller;

import grupp01othello.view.GameFrame;
import grupp01othello.view.BoardView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameManager {

    GameFrame othelloFrame;
    BoardView othelloBoard;

    public GameManager(Stage primaryStage) {
       othelloFrame = new GameFrame(primaryStage);
        othelloBoard = new BoardView();
    }

    public void setupGameBoard(){
        othelloFrame.setBoard(othelloBoard.getBoard());
        othelloFrame.startFrame();
//        othelloBoard.board.setOnMouseClicked(event -> {
//
//            Circle chip = new Circle(30, 30, 15);
//            chip.setStroke(Color.BLACK);
//            chip.setFill(Color.WHITE);
//        });
    }

}
