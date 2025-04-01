public class Application {

    public static void main(String[] args) {
        Notification notification = new Notification();
        User user1 = new User("1");
        User user2 = new User("2");

        notification.addObserver(user1);
        notification.addObserver(user2);

        notification.sendMessage("Some message");
    }
}
