import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<> ();
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    public void add(T value) {
        this.values.add (value);
    }

    public long getCountOfGreaterElementsThan(T value) {
        return this.values.stream ()
                .filter (e -> e.compareTo (value) > 0).count ();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder ();

        for (T value : values) {
            sb.append (String.format ("%s: %s",
                            value.getClass ().getName (), value))
                    .append (System.lineSeparator ());
        }

        return sb.toString ();
    }

}
