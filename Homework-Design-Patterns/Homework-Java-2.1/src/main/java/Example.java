public class Example {

    public static void main(String[] args) {
        Config config = Config.getInstance();

        System.out.println("Culoare: " + config.getColor());
        System.out.println("Greutate: " + config.getWeight());
    }
}
