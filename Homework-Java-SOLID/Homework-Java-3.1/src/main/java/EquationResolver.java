public class EquationResolver {
    private EquationResolver() {}

    public static Solution resolveGrade1Equation(float a, float b) {
        if (a == 0) {
            if (b == 0) {
                throw new InfiniteSolutionException("Equation has infinite solutions");
            }
            else {
                throw new NoSolutionException("Equation has no solutions");
            }
        }

        return new Solution(-b / a);
    }
}
