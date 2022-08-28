import java.util.*;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<> ();
    }

    public List<T> getValues() {
        return values;
    }

    public int getSize() {
        return values.size ();
    }

    public void add(T element) {
        values.add (element);
    }

    public T remove(int index) {
        return this.values.remove (index);
    }

    public boolean contains(T element) {
        return this.values.contains (element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap (this.values, secondIndex, firstIndex);
    }

    public T getMin() {
        return getValues ().stream ().min (Comparator.naturalOrder ())
                .get ();
    }

    public T getMax() {
        return getValues ().stream ().max (Comparator.naturalOrder ())
                .get ();
    }

    public int countGreaterThan(T element) {
        return (int) this.values.stream ()
                .filter (e -> e.compareTo (element) > 0)
                .count ();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder ();

        Iterator<T> iterator = values.iterator ();

        while (iterator.hasNext ()) {
            sb.append (iterator.next ())
                    .append (System.lineSeparator ());
        }

        return sb.toString ().trim ();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T> () {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return values.get (counter) != null;
            }

            @Override
            public T next() {
                return values.get (counter++);
            }
        };
    }
}
