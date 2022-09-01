public class Tuple<F, S,T> {
    private F first;
    private S second;

    private T third;

    public Tuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getThird() {
        return third;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return String.format ("%s -> %s -> %s",
                getFirst (), getSecond (),getThird ());
    }
}
