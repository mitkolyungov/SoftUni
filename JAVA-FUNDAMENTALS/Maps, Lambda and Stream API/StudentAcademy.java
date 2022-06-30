import java.util.*;
import java.util.stream.Collectors;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, List<Double>> students = new LinkedHashMap<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i ++) {
            String name = scanner.nextLine ();
            double grade = Double.parseDouble (scanner.nextLine ());

            if (!students.containsKey (name)) {
                students.put (name, new ArrayList<> ());
            }
            students.get (name).add (grade);
        }

        students.forEach ((k, v) -> {
                    double average = v.stream ().mapToDouble (Double::doubleValue)
                            .average ().getAsDouble ();

                    if (average >= 4.50) {
                        System.out.printf ("%s -> %.2f%n", k, average);
                    }
                }
        );
    }
}
