package service;
import java.util.ArrayList;
import model.Student;

public class GradeTracker {

    private ArrayList<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println("--------------------");
            System.out.println(s);
        }
    }

    public Student searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    public Student findTopper() {

        if (students.isEmpty())
            return null;

        Student topper = students.get(0);

        for (Student s : students) {

            if (s.getAverage() > topper.getAverage()) {
                topper = s;
            }
        }

        return topper;
    }

    public double getClassAverage() {

        if (students.isEmpty())
            return 0;

        double total = 0;

        for (Student s : students) {
            total += s.getAverage();
        }

        return total / students.size();
    }
}