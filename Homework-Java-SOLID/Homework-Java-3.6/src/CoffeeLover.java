import java.util.List;

public class CoffeeLover {

    private List<CoffeeMachine> coffeeMachines;

    public CoffeeLover(List<CoffeeMachine> coffeeMachines) {
        this.coffeeMachines = coffeeMachines;
    }

    public void makeCoffee() {
        coffeeMachines.forEach(CoffeeMachine::start);
    }

    public List<CoffeeMachine> getCoffeeMachines() {
        return coffeeMachines;
    }

    public void setCoffeeMachines(List<CoffeeMachine> coffeeMachines) {
        this.coffeeMachines = coffeeMachines;
    }
}
