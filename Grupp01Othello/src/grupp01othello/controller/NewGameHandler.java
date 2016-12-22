/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author Markus
 */
public class NewGameHandler implements EventHandler<ActionEvent> {

    private Stage primaryStage;

    public NewGameHandler(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    /**
     * metoden anropas av att användaren har klickat på nytt parti knappen och
     * då skapar en ny spelomgång.
     */
    public void handle(ActionEvent event) {

        System.out.println("Nytt Parti");

        primaryStage.close();
        GameManager othello = new GameManager(primaryStage);
        othello.run();

    }

}
