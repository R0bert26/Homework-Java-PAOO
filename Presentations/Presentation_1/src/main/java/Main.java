import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            Solution.resolveEquation(1, 2, 3);
        }
        catch (NegativeDeltaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Solution.sumArray(array);
    }
}
