/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view;

import grupp01othello.model.Move;
import java.util.ArrayList;

/**
 *
 * @author optimusprime (Elvir)
 */
public interface GridObserver {

    public abstract void updateGrid(int[][] gameGrid);


}
