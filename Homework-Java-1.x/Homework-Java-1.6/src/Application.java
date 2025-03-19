import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Alexandru", "Cicaldau", new Address("Craiova", "Str. 1 Mai"), 2),
                new Student("Alexandru", "Mitrita", new Address("Craiova", "Str. 10 Mai"), 2)
        ));

        List<Teacher> teachers = new ArrayList<>(Arrays.asList(
                new Teacher("Mirel", "Radoi", new Address("Craiova", "Str. 3 Mai"), "Matematica")
        ));

        Course course = Course.createNewCourse("Matematica", teachers, students);
        System.out.println(course);

        course.addStudentToCourse(new Student("Andrei", "Ivan", new Address("Craiova", "Str. 1 Mai"), 2));
        course.addTeacherToCourse(new Teacher("Costel", "Galca", new Address("Craiova", "Str. 3 Mai"), "Matematica"));
        System.out.println("\n" + course);
    }
}
