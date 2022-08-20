import java.util.*;

public class logsAggregator {

    private static class User {
        int duration;
        Set<String> ip;

        public User() {
            duration = 0;
            ip = new TreeSet<> ();
        }

        public int getDuration() {
            return duration;
        }

        public void addDuration(int duration) {
            this.duration += duration;
        }

        public Set<String> getIp() {
            return ip;
        }

        public void addIp(String ip) {
            this.ip.add (ip);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, User> users = new TreeMap<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine ().split ("\\s+");

            String ip = input[0];
            String name = input[1];
            int duration = Integer.parseInt (input[2]);

            User user;

            if (!users.containsKey (name)) {
                user = new User ();

                user.addDuration (duration);
                user.addIp (ip);

                users.put (name, user);

            } else {
                user = users.get (name);

                user.addDuration (duration);
                user.addIp (ip);
            }

        }

        users.forEach ((k, v) -> {

            System.out.printf ("%s: %d ", k, v.getDuration ());

            System.out.println (formatter (v.getIp ()).trim ());
        });
    }


    private static String formatter(Set<String> ip) {
        StringBuilder sb = new StringBuilder ();

        for (String s : ip) {
            sb.append (s).append (", ");
        }
        sb.deleteCharAt (sb.length () - 1);
        sb.deleteCharAt (sb.length () - 1);

        return "[" + sb + "]";
    }
}
