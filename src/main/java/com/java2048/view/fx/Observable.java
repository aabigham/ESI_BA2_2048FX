package com.java2048.view.fx;

/**
 * This class represents an observable object. An observable object can have one
 * or more observers. After an observable instance changes, all of its observers
 * are being notified of the change by a call to their update method.
 *
 * @author Amine-Ayoub Bigham {@literal <g54985@etu.he2b.be>}
 */
public interface Observable {

    /**
     * Adds an observer to the set of observers for this object, provided that
     * it is not the same as some observer already in the set.
     *
     * @param obs an observer to be added.
     */
    public void registerObserver(Observer obs);

    /**
     * Removes an observer from the set of observers of this object.
     *
     * @param obs an observer to be deleted.
     */
    public void removeObserver(Observer obs);

    /**
     * If this object has changed, then notify all of its observers.
     */
    public void notifyObservers();

}
