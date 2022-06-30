import java.util.*;

public class SoftUniExamResults {
    static class Result {
        private String languageName;
        private int points;

        private int submissionsCount;

        public Result(String language, int points) {
            this.languageName = language;
            this.points = points;
            this.submissionsCount = 0;
        }

        public String getLanguageName() {
            return languageName;
        }

        public int getSubmissionsCount() {
            return submissionsCount;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        private void submissionIncrement() {
            submissionsCount++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, List<Result>> data = new LinkedHashMap<> ();

        Set<Result> submissions = new LinkedHashSet<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("exam finished")) {
            String[] tokens = command.split ("-");

            if (tokens.length == 3) {

                String name = tokens[0].trim ();
                String languageName = tokens[1].trim ();
                int points = Integer.parseInt (tokens[2].trim ());

                if (data.containsKey (name)) {
                    if (existUserLanguage (data, name, languageName)) {

                        int currentPoints = getCurrentPoints (data, name, languageName);

                        if (currentPoints < points) {
                            setNewPoints (data, name, languageName, points);
                        }
                    }

                } else {
                    Result language = new Result (languageName, points);

                    data.putIfAbsent (name, new ArrayList<> ());

                    addSubmission (data, submissions, languageName, language);

                    data.get (name).add (language);

                }

                increaseSubmissions (data, languageName);

            } else if (tokens.length == 2) {
                String name = tokens[0];

                data.remove (name);
            }
            command = scanner.nextLine ();
        }

        printResults (data);

        printSubmissions (submissions);

    }

    private static void printSubmissions(Set<Result> submissions) {
        System.out.println ("Submissions:");

        for (Result submission : submissions) {
            System.out.printf ("%s - %d%n"
                    , submission.getLanguageName (), submission.getSubmissionsCount ());
        }
    }

    private static void printResults(Map<String, List<Result>> data) {
        System.out.println ("Results:");

        for (Map.Entry<String, List<Result>> entry : data.entrySet ()) {
            System.out.printf ("%s | %s%n", entry.getKey (), entry.getValue ().get (0).getPoints ());
        }
    }

    private static void increaseSubmissions(Map<String, List<Result>> data, String languageName) {
        data.values ().forEach (v -> v.stream ()
                .filter (e -> e.languageName.equals (languageName))
                .forEach (Result::submissionIncrement));
    }

    private static void addSubmission(Map<String, List<Result>> data, Set<Result> submissions, String languageName, Result language) {
        boolean found = false;
        for (List<Result> value : data.values ()) {
            for (Result result : value) {
                if (result.languageName.equals (languageName)) {
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            submissions.add (language);
        }
    }

    private static boolean existUserLanguage(Map<String, List<Result>> data, String name, String languageName) {
        return data.get (name)
                .stream ().anyMatch (v -> v.languageName.equals (languageName));
    }

    private static void setNewPoints(Map<String, List<Result>> data, String name, String languageName, int points) {
        data.get (name)
                .stream ().filter (v -> v.languageName.equals (languageName))
                .findAny ().get ().setPoints (points);
    }

    private static int getCurrentPoints(Map<String, List<Result>> data, String name, String languageName) {
        return data.get (name)
                .stream ().filter (v -> v.languageName.equals (languageName))
                .findAny ().get ().getPoints ();
    }
}
