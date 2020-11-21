package shilkin.third;

public class Triple <T,U,P>{

    private final T first;
    private final U second;
    private final P third;

    public Triple(T first, U second, P third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public P getThird() {
        return third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?,?,?> triple = (Triple<?,?,?>) o;
        return this.first == triple.first && this.second == triple.second && this.third == triple.third;
    }

    @Override
    public int hashCode() {
        int firstHash = this.first.hashCode();
        int secondHash = this.second.hashCode();
        int thirdHash = this.third.hashCode();
        return firstHash + secondHash + thirdHash;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}