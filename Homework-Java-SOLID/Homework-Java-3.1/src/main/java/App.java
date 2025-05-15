import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Solution solution = EquationResolver.resolveGrade1Equation(1, 2);
            objectMapper.writeValue(new File("result.json"), solution);
        }
        catch (IOException | NoSolutionException | InfiniteSolutionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
