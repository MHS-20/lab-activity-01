package MVC.Observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

public class Model {
    int state;
    private List<Observer> observers = new ArrayList<>();

    public Model(){
        state = 0;
    }

    public int getState() {
        return state;
    }

    public void incrementState() {
        state++;
        notifyObservers();
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}
