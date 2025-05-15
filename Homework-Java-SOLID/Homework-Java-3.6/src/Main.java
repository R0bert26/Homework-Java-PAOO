import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine simple = new SimpleCoffeeMachine();
        CoffeeMachine complex = new ComplexCoffeeMachine();

        CoffeeLover lover = new CoffeeLover(Arrays.asList(simple, complex));

        lover.makeCoffee();
    }
}
