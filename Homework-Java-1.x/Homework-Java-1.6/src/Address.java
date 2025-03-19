public class Address {

    protected String city;
    protected String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public static void changeStudentAddress(Address newAddress, Student student) {
        student.setAddress(newAddress);
    }

    public static void changeTeacherAddress(Address newAddress, Teacher teacher) {
        teacher.setAddress(newAddress);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return city + ", " + street;
    }
}
