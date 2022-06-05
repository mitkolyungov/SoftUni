import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMainUpdated {

    static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String city;

        public Student(String firstName, String lastName, int age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Student> studentList = new ArrayList<> ();

        String line = scanner.nextLine ();

        while (!line.equals ("end")) {
            String[] tokens = line.split (" ");

            String firstName = tokens[0];
            String secondName = tokens[1];
            int age = Integer.parseInt (tokens[2]);
            String city = tokens[3];

            if (!overwriteIfExists (studentList, firstName, secondName, age, city)) {
                studentList.add (new Student (firstName, secondName, age, city));
            }
            line = scanner.nextLine ();
        }

        String city = scanner.nextLine ();

        studentList.stream ()
                .filter (student -> student.getCity ().equals (city))
                .forEach (student -> System.out.printf ("%s %s is %d years old\n"
                        , student.getFirstName (), student.getLastName (), student.getAge ()));
    }

    private static boolean overwriteIfExists(List<Student> studentList, String firstName, String secondName, int age, String city) {
        for (Student student : studentList) {
            if (student.getFirstName ().equals (firstName)
                    && student.lastName.equals (secondName)) {
                student.setAge (age);
                student.setCity (city);
                return true;
            }
        }
        return false;
    }
}
