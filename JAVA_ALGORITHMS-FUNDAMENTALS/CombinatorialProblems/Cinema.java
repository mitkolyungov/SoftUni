import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {
    static List<String> friends;
    static String[] places;
    static String[] combinations;
    static boolean[] used;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));

        friends = Arrays.stream (bufferedReader.readLine ().split (", "))
                .collect (Collectors.toList ());

        places = new String[friends.size ()];


        String commands = bufferedReader.readLine ();

        while (!commands.equals ("generate")) {
            String[] tokens = commands.split (" - ");
            String name = tokens[0];
            int place = Integer.parseInt (tokens[1]);

            places[place - 1] = name;

            friends.remove (name);

            commands = bufferedReader.readLine ();
        }
        combinations = new String[friends.size ()];
        used = new boolean[friends.size ()];

        generate (0);
    }

    private static void generate(int index) {
        if (index == combinations.length) {
            print ();
        } else {
            for (int i = 0; i < friends.size (); i++) {
                if (!used[i]) {
                    used[i] = true;
                    combinations[index] = friends.get (i);
                    generate (index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        int index = 0;
        String[] out = new String[places.length];

        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                out[i] = combinations[index++];
            } else {
                out[i] = places[i];
            }
        }
        System.out.println (String.join (" ", out));
    }
}
