public class User implements Observer {

    String id;

    public User(String id) {
        this.id = id;
    }

    @Override
    public void listenMessage(String message) {
        System.out.println("Message received by user " + id + ": " + message);
    }
}
