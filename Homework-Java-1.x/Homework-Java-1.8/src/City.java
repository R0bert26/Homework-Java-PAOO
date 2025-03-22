import java.util.List;

public class City {

    private String name;
    private List<Hotel> hotels;

    public City(String name, List<Hotel> hotels) {
        this.name = name;
        this.hotels = hotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public void addHotel(Hotel hotel) {
        this.hotels.add(hotel);
    }

    public void removeHotel(Hotel hotel) {
        this.hotels.remove(hotel);
    }

    public void displayTourists() {

        for (Hotel hotel: hotels) {
            for (Tourist tourist: hotel.getTourists()) {
                System.out.println(tourist.getFirstName() + " " + tourist.getLastName() + " from " + hotel.getName());
            }
        }
    }

    public boolean isTouristInCity(Tourist tourist) {
        for (Hotel hotel: hotels) {
            if (hotel.getTourists().contains(tourist)) {
                return true;
            }
        }

        return false;
    }
}
