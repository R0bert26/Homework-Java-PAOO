public class AdvancedCoffeeMachine implements CoffeeMaker, EspressoMaker, AmericanoMaker {

    @Override
    public void makeAmericano() {
        System.out.println("Making americano");
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making coffee");
    }

    @Override
    public void makeEspresso() {
        System.out.println("Making espresso");
    }
}
