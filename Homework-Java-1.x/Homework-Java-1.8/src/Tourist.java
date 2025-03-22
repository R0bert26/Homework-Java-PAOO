public class Tourist extends Person{

    private Hotel hotel;

    public Tourist(String firstName, String lastName, Address address, Hotel hotel) {
        super(firstName, lastName, address);
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void changeHotel(Hotel newHotel){
        hotel.getTourists().remove(this);
        newHotel.getTourists().add(this);
        this.hotel = newHotel;
    }
}
