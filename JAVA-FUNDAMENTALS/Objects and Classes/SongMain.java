import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongMain {
    static class Song {
        private String typeList;
        private String name;
        private String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int numberOfSongs = Integer.parseInt (scanner.nextLine ());
        List<Song> songs = new ArrayList<> ();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] songInfo = scanner.nextLine ().split ("_");

            String type = songInfo[0];
            String name = songInfo[1];
            String time = songInfo[2];

            songs.add (new Song (type, name, time));
        }

        String typeList = scanner.nextLine ();

        if (typeList.equals ("all")) {
            songs.forEach (s -> System.out.println (s.getName ()));
        } else {
            songs.stream ().filter (s -> s.getTypeList ().equals (typeList))
                    .forEach (s -> System.out.println (s.getName ()));
        }
    }
}
