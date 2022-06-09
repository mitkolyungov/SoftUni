import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        String[] info = scanner.nextLine ().split (";");

        List<String> robots = new ArrayList<> ();
        List<Integer> processTime = new ArrayList<> ();
        int[] worktime = new int[info.length];


        // splitting the info one more time
        for (String s : info) {
            String[] line = s.split ("-");
            robots.add (line[0]);
            processTime.add (Integer.valueOf (line[1]));
        }

        int[] time = Arrays.stream (scanner.nextLine ().split (":"))
                .mapToInt (Integer::parseInt).toArray ();

        int startingTime = time[0] * 3600 + time[1] * 60
                + time[2];

        ArrayDeque<String> products = new ArrayDeque<> ();

        String command = scanner.nextLine ();

        // adding the products
        while (!command.equals ("End")) {
            products.offer (command);
            command = scanner.nextLine ();
        }


        while (!products.isEmpty ()) {
            startingTime++;
            String product = products.poll ();
            boolean isWorking = false;

            for (int i = 0; i < robots.size (); i++) {
                if (worktime[i] == 0 && !isWorking) {
                    worktime[i] = processTime.get (i);
                    isWorking = true;
                    printRobotData (robots.get (i), product, startingTime);
                }
                if (worktime[i] > 0) {
                    worktime[i]--;
                }
            }

            if (!isWorking) {
                products.offer (product);
            }

        }
    }

    private static void printRobotData(String robot, String product, int beginSeconds) {
        long s = beginSeconds % 60;
        long m = (beginSeconds / 60) % 60;
        long h = (beginSeconds / (60 * 60)) % 24;
        System.out.println (robot + " - " + product +
                String.format (" [%02d:%02d:%02d] ", h, m, s));
    }
}
