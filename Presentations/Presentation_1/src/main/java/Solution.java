import java.util.List;

public class Solution {

    private Solution() {}

    public static void resolveEquation(double a, double b, double c) {

         double delta = b * b - 4 * a * c;

         if (delta < 0) {
             throw new NegativeDeltaException("No real solutions, delta < 0");
         }

         double x1 = (-b + Math.sqrt(delta)) / (2 * a);
         double x2 = (-b - Math.sqrt(delta)) / (2 * a);

         System.out.println("x1 = " + x1);
         System.out.println("x2 = " + x2);
    }

    public static void sumArray(List<Integer> array) {

        int sum = array.stream().reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
    }
}
