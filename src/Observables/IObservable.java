package Observables;
import Observers.IObserver;

public interface IObservable {
    public void add(IObserver observer);
    public void remove(IObserver observer);
    public void notifyObservers();

    //ArrayList<IObserver> listObservers;
    //In its most common form, an interface
    //is a group of related methods with empty bodies. A bicycle's behavior, if specified as an interface, might appear as follows:
}
