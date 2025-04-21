import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>(List.of(2, 5, 7, 1, 34, 11));
        myList.sort(Comparator.naturalOrder());
        System.out.println(myList);
    }
}
