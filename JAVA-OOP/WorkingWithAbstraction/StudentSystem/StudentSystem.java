import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<> ();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void ParseCommand(String[] args) {
        String command = args[0];

        switch (command) {

            case "Create": {
                String name = args[1];
                int age = Integer.parseInt (args[2]);
                double grade = Double.parseDouble (args[3]);

                if (!students.containsKey (name)) {
                    var student = new Student (name, age, grade);
                    students.put (name, student);
                }
                break;

            }
            case "Show": {
                String name = args[1];

                if (students.containsKey (name)) {
                    Student student = students.get (name);

                    System.out.printf ("%s is %s years old. %s%n"
                            , student.getName (), student.getAge (), getCommentary (student));
                }
                break;
            }
        }
    }

    private String getCommentary(Student student) {
        if (student.getGrade () >= 5.00) {
            return "Excellent student.";
        } else if (student.getGrade () >= 3.50) {
            return "Average student.";
        }
        return "Very nice person.";
    }
}
