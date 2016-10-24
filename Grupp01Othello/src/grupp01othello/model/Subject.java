/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;

import grupp01othello.view.GridObserver;
//exit
/**
 *
 * @author optimusprime (Elvir)
 */
public interface Subject {
    
    public abstract void register(GridObserver o);
    public abstract void unregister(GridObserver o);
    public abstract void notifyObserver();
}
