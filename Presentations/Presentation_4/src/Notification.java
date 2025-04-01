import java.util.ArrayList;
import java.util.List;

public class Notification implements Publisher {

    List<Observer> observers;

    public Notification() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendMessage(String event) {
        for (Observer observer : observers) {
            observer.listenMessage(event);
        }
    }
}
