/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;

import grupp01othello.controller.GameManager;
import grupp01othello.model.Player;
/**
 *
 * @author Markus
 */
public class GameGrid {

  static  int grid[][] = new int[8][8];
 public  GameGrid(){
  initGrid();
  }
    /**
     * initGrid initierar matrisen med 0 i alla rutor sedan så sätter den dom 4
     * mitt i matrisen till svart elr vit som start på hela spelet.
     */
    void initGrid() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                grid[row][col] = 0;
            }

        }
        grid[3][4] = 2;
        grid[3][3] = 1;
        grid[4][3] = 2;
        grid[4][4] = 1;
    }
//      updateBoard(){
//          
//          
//      }

    /**
     * boardIsFull loopar genom alla platser i matrisen och returnerar true om
     * hela matrisen är full med spelpjäser
     */
    boolean boardIsFull() {
        int flag = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (grid[x][y] != 0) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * win metoden loopar genom hela matrisen och ökar 2 variablar beroende på
     * om den träffar på en svart eller vit spelpjäs och den returnerar sedan
     * vilken som har mest antal spelpjäser av sin färg dvs. räknar ut vem som
     * har vunnit
     */
    int win() {
        int black = 0, white = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (grid[x][y] != 0) {
                    if (grid[x][y] == 1) {
                        black += 1;
                    } else {
                        white += 1;
                    }
                }
            }
        }
        if (black > white) {
            return black;
        }

        return white;
    }

    public static boolean isPossibleMove(int row, int col) {

        //if ((grid[x + 1][y]) || (grid[x - 1][y]) || (grid[x][y + 1]) || (grid[x][y - 1]) || (grid[x + 1][y + 1]) || (grid[x - 1][y + 1]) ||(grid[x + 1][y - 1]) != 0)
        if(grid[row+1][col] != 0 /*|| (grid[row-1][col])!=0 || (grid[row][col+1]) !=0 || (grid[row][col-1]) !=0*/ ){
        return true;
        }
        
        return false;
        
    }
}
