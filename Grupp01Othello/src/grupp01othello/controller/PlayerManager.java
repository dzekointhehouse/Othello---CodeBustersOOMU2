/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.controller;
import grupp01othello.model.HumanPlayer;
import grupp01othello.model.Player;
import grupp01othello.view.setUpGameDialog;
/**
 *
 * @author Markus
 */
public class PlayerManager   {
    
    private static int id = 1;
    setUpGameDialog dialog = new setUpGameDialog();
    Player player1, player2;
    
    PlayerManager(){
  
           String typePlayer,name;
      for(int i=0;i<2;i++){
             typePlayer = dialog.infoBox();
             name = dialog.infoBoxName();
    
switch(typePlayer) {
    case "Human": this.player1 = new HumanPlayer(id, name); id++; break;
    //case "Computer": this.player1 = new LocalComputerPlayer(id, name); id++; break;
    //case "Remote": this.player1 = new RemoteComputerPlayer(id, name); id++; break;
}
}


}
    
}
