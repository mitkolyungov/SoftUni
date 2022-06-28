import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticlesUpdated {
    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
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

        @Override
        public String toString() {
            return String.format ("%s - %s: %s"
                    , getTitle (), getContent (), getAuthor ());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        List<Article> articleList = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine ().split (", ");

            String title = info[0];
            String content = info[1];
            String author = info[2];

            articleList.add (new Article (title, content, author));
        }

        for (Article article : articleList) {
            System.out.println (article);
        }
    }
}
