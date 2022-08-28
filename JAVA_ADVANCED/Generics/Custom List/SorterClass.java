import java.util.Collections;
import java.util.List;

public class SorterClass<T> {
    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        for (int i = 0; i < customList.getValues ().size (); i++) {
            T element = customList.getValues ().get (i);
            for (int j = i + 1; j < customList.getValues ().size (); j++) {
                if (element.compareTo (customList.getValues ().get (j)) > 0) {
                    customList.swap (i, j);
                }
            }
        }
    }
}
