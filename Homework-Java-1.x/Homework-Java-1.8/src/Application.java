import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        City city = new City("New York", new ArrayList<>());

        Hotel hotel1 = new Hotel("Hotel 1", city, new ArrayList<>());
        Hotel hotel2 = new Hotel("Hotel 2", city, new ArrayList<>());

        Tourist tourist1 = new Tourist("John", "Doe", new Address("New York", "123 Main St"), hotel1);
        Tourist tourist2 = new Tourist("Jane", "Doe", new Address("New York", "456 Main St"), hotel2);

        hotel1.addTourist(tourist1);
        hotel2.addTourist(tourist2);

        city.addHotel(hotel1);
        city.addHotel(hotel2);

        city.displayTourists();
    }
}
