import java.util.*;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> lessons = Arrays.stream (scanner.nextLine ().split (", "))
                .collect (Collectors.toList ());

        String commands = scanner.nextLine ();

        while (!commands.equals ("course start")) {

            String[] tokens = commands.split (":");

            String command = tokens[0];

            String lessonTitle = tokens[1];

            switch (command) {
                case "Add":

                    if (!lessons.contains (lessonTitle)) {

                        lessons.add (lessonTitle);
                    }
                    break;

                case "Insert":

                    int index = Integer.parseInt (tokens[2]);

                    if (!lessons.contains (lessonTitle)) {
                        if (index >= 0 && index < lessons.size ()) {
                            lessons.add (index, lessonTitle);
                        }
                    }
                    break;

                case "Remove": {

                    lessons.remove (lessonTitle);

                    String exerciseTitle = lessonTitle + "-Exercise";

                    lessons.remove (exerciseTitle);
                    break;
                }

                case "Swap":

                    String lessonTitleToSwap = tokens[2];

                    if (lessons.contains (lessonTitle) && lessons.contains (lessonTitleToSwap)) {

                        int lessonTitleIndexFirst = lessons.indexOf (lessonTitle);
                        int lessonTitleIndexSecond = lessons.indexOf (lessonTitleToSwap);

                        Collections.swap (lessons, lessonTitleIndexFirst, lessonTitleIndexSecond);

                        if (lessons.contains (lessonTitle + "-Exercise")) {

                            String exerciseName = lessonTitle + "-Exercise";
                            lessons.remove (exerciseName);

                            if (lessonTitleIndexSecond + 1 < lessons.size ()) {
                                lessons.add (lessonTitleIndexSecond + 1, exerciseName);
                            } else {
                                lessons.add (exerciseName);
                            }

                        } else if (lessons.contains (lessonTitleToSwap + "-Exercise")) {
                            String exerciseName = lessonTitleToSwap + "-Exercise";
                            lessons.remove (exerciseName);

                            if (lessonTitleIndexFirst + 1 < lessons.size ()) {
                                lessons.add (lessonTitleIndexFirst + 1, exerciseName);
                            } else {
                                lessons.add (exerciseName);
                            }
                        }
                    }
                    break;

                case "Exercise": {

                    int indexOfLesson = lessons.indexOf (lessonTitle);

                    String exerciseName = lessonTitle + "-Exercise";

                    boolean doesLessonExist = lessons.contains (lessonTitle);

                    if (doesLessonExist) {
                        if (!lessons.contains (exerciseName)) {
                            if (indexOfLesson < lessons.size ()) {
                                lessons.add (indexOfLesson + 1, exerciseName);
                            } else {
                                lessons.add (exerciseName);
                            }
                        }

                    } else {
                        lessons.add (lessonTitle);
                        lessons.add (exerciseName);
                    }
                    break;
                }
            }
            commands = scanner.nextLine ();
        }


        print (lessons);
    }

    private static void print(List<String> lessons) {
        for (int index = 0; index < lessons.size (); index++) {
            System.out.printf ("%d.%s%n", index + 1, lessons.get (index));
        }
    }

}