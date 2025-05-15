import java.util.List;

public class CoffeeLover {

    private List<CoffeeMachine> machines;

    public CoffeeLover(List<CoffeeMachine> machines) {
        this.machines = machines;
    }

    public void makeCoffee() {
        for (CoffeeMachine machine : machines) {
            machine.start();
        }
    }

    public List<CoffeeMachine> getMachines() {
        return machines;
    }

    public void setMachines(List<CoffeeMachine> machines) {
        this.machines = machines;
    }
}
