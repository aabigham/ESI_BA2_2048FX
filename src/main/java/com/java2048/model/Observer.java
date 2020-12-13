package com.java2048.model;

/**
 * A class can implement the Observer interface when it wants to be informed of
 * changes in observable objects.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public interface Observer {

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an Observable object's notifyObservers method to have
     * all the object's observers notified of the change.
     */
    public void update();

}
