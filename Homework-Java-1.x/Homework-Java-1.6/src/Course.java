import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {

    private String name;
    private List<Teacher> teachers;
    private List<Student> students;

    private Course(String name, List<Teacher> teacher, List<Student> students) {
        this.name = name;
        this.teachers = teacher;
        this.students = students;
    }

    public static Course createNewCourse(String name, List<Teacher> teachers, List<Student> students) {
        return new Course(name, teachers, students);
    }

    public void addStudentToCourse(Student student) {
        this.students.add(student);
    }

    public void removeStudentFromCourse(Student student) {
        this.students.remove(student);
    }

    public void addTeacherToCourse(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void removeTeacherFromCourse(Teacher teacher) {
        this.teachers.remove(teacher);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        String studentsList = this.students.stream().map(Student::toString).collect(Collectors.joining("\n"));
        String teachersList = this.teachers.stream().map(Teacher::toString).collect(Collectors.joining("\n"));

        return "Course: " + name +
                "\n\nTeachers:\n" + teachersList +
                "\nStudents:\n" + studentsList;
    }
}
