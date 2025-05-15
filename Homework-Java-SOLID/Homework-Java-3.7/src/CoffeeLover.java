import java.util.ArrayList;
import java.util.List;

public class CoffeeLover {

    private List<CoffeeMachine> coffeeMachines = new ArrayList<>();

    public void setCoffeeMachines(List<CoffeeMachine> coffeeMachines) {
        this.coffeeMachines = coffeeMachines;
    }

    public void addCoffeeMachine(CoffeeMachine machine) {
        this.coffeeMachines.add(machine);
    }

    public void makeCoffee() {
        coffeeMachines.forEach(CoffeeMachine::start);
    }
}
