import model.Student;
import service.GradeTracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GradeTracker tracker = new GradeTracker();

        while (true) {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Find Topper");
            System.out.println("5. Class Statistics");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    Student student = new Student(id, name);

                    System.out.print("How many subjects? ");
                    int subjects = sc.nextInt();

                    for (int i = 1; i <= subjects; i++) {

                        System.out.print("Enter marks for Subject " + i + ": ");
                        int marks = sc.nextInt();

                        student.addMark(marks);
                    }

                    tracker.addStudent(student);

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:

                    tracker.displayAllStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    Student found = tracker.searchStudent(searchId);

                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Student Not Found!");

                    break;

                case 4:

                    Student topper = tracker.findTopper();

                    if (topper != null) {

                        System.out.println("\n===== TOPPER =====");
                        System.out.println(topper);
                    }
                    else {
                        System.out.println("No students available.");
                    }

                    break;

                case 5:

                    System.out.println("Class Average: "
                            + String.format("%.2f",
                            tracker.getClassAverage()));

                    break;

                case 6:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}