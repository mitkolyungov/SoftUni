import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> list1 = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());

        List<Integer> list2 = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());

        do {

            if (list1.size () != 0) {
                System.out.print (list1.remove (0) + " ");
            }

            if (list2.size () != 0) {
                System.out.print (list2.remove (0) + " ");
            }

        } while (list1.size () != 0 || list2.size () != 0);
    }
}
