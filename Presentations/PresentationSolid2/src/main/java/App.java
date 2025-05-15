public class App {

    public static void main(String[] args) {
        BasicCoffeeMachine basicCoffeeMachine = new BasicCoffeeMachine();
        AdvancedCoffeeMachine advancedCoffeeMachine = new AdvancedCoffeeMachine();

        basicCoffeeMachine.makeCoffee();

        advancedCoffeeMachine.makeCoffee();
        advancedCoffeeMachine.makeEspresso();
    }
}
