/*
 * Subject interface som frikopplar gamegrid från gameboard genom
 * att följa observer mönstret.
 */
package grupp01othello.model;

import grupp01othello.view.GridObserver;
import java.util.ArrayList;

/**
 *
 * @author optimusprime (Elvir)
 */
public interface Subject {
    
    public abstract void register(GridObserver o);
    public abstract void unregister(GridObserver o);
    public abstract void notifyObserver();
}
