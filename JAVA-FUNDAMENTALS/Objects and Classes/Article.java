import java.util.Scanner;

public class Article {
    static class Articles {
        String title;
        String content;
        String author;

        public Articles(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        public void rename(String title) {
            this.title = title;
        }

        public void edit(String content) {
            this.content = content;
        }

        public void changeAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format ("%s - %s: %s"
                    , getTitle (), getContent (), getAuthor ());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] articleInfo = readArray (scanner, ", ");

        int n = Integer.parseInt (scanner.nextLine ());

        String title = articleInfo[0];
        String content = articleInfo[1];
        String author = articleInfo[2];

        Articles articles = new Articles (title, content, author);

        for (int i = 0; i < n; i++) {
            String[] tokens = readArray (scanner, ": ");
            String command = tokens[0];
            String newInfo = tokens[1];

            switch (command) {
                case "Edit": {
                    articles.edit (newInfo);
                    break;
                }
                case "Rename": {
                    articles.rename (newInfo);
                    break;
                }
                case "ChangeAuthor": {
                    articles.changeAuthor (newInfo);
                    break;
                }
            }
        }

        System.out.println (articles);
    }

    private static String[] readArray(Scanner scanner, String delimeter) {
        return scanner.nextLine ().split (delimeter);
    }
}
