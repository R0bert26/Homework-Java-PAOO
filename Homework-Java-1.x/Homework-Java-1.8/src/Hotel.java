import java.util.List;

public class Hotel {

    private String name;
    private City city;
    private List<Tourist> tourists;

    public Hotel(String name, City city, List<Tourist> tourists) {
        this.name = name;
        this.city = city;
        this.tourists = tourists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(List<Tourist> tourists) {
        this.tourists = tourists;
    }

    public void addTourist(Tourist tourist) {
        tourists.add(tourist);
    }
}
