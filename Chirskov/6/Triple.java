import java.util.Objects;

public class Triple<E, K, T> extends Pair {
    private T third;

    Triple(E first, K second, T third) {
        super(first, second);
        this.third = third;
    }

    public void setThird(T third) {
        this.third = third;
    }

    public T getThird() {
        return third;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getFirst()).append(" ").append(getSecond())
                .append(" ").append(third).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        if (third != triple.third)
            return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), third);
    }
}
