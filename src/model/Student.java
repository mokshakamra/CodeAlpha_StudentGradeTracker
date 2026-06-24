package model;
import java.util.ArrayList;
import java.util.Collections;

    public class Student {

        private int id;
        private String name;
        private ArrayList<Integer> marks;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
            this.marks = new ArrayList<>();
        }

        public void addMark(int mark) {
            marks.add(mark);
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getAverage() {
            if (marks.isEmpty()) {
                return 0;
            }

            int sum = 0;

            for (int mark : marks) {
                sum += mark;
            }

            return (double) sum / marks.size();
        }

        public int getHighestScore() {
            if (marks.isEmpty()) {
                return 0;
            }

            return Collections.max(marks);
        }

        public int getLowestScore() {
            if (marks.isEmpty()) {
                return 0;
            }

            return Collections.min(marks);
        }

        public String getGrade() {

            double avg = getAverage();

            if (avg >= 90)
                return "A+";
            else if (avg >= 80)
                return "A";
            else if (avg >= 70)
                return "B";
            else if (avg >= 60)
                return "C";
            else
                return "F";
        }

        @Override
        public String toString() {
            return "ID: " + id +
                    "\nName: " + name +
                    "\nAverage: " + String.format("%.2f", getAverage()) +
                    "\nHighest Score: " + getHighestScore() +
                    "\nLowest Score: " + getLowestScore() +
                    "\nGrade: " + getGrade();
        }
    }
