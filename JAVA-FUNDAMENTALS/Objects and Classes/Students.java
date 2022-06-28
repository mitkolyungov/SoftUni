import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student implements Comparable<Student> {
        String firstName;
        String secondName;
        double grade;

        public Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return String.format ("%s %s: %.2f"
                    , getFirstName (), getSecondName (), getGrade ());
        }

        @Override
        public int compareTo(Student student) {
            if (this.grade < student.grade)
                return -1;       // Neither val is NaN, thisVal is smaller
            if (this.grade > student.grade)
                return 1;        // Neither val is NaN, thisVal is larger

            long thisBits = Double.doubleToLongBits (this.grade);
            long anotherBits = Double.doubleToLongBits (student.grade);

            return (Long.compare (thisBits, anotherBits));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        List<Student> studentList = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine ().split ("\\s+");

            String firstName = info[0];
            String secondName = info[1];
            double grade = Double.parseDouble (info[2]);

            studentList.add (new Student (firstName, secondName, grade));
        }

        studentList.stream ().sorted (Comparator.reverseOrder ())
                .forEach (System.out::println);
    }
}
