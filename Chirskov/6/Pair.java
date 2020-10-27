import java.util.Objects;

public class Pair<T, E> {
    private T first;
    private E second;

    Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(first).append(" ").append(second).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        if (first != pair.first) {
            return false;
        }
        if (second != pair.second) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
