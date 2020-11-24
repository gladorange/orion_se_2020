package com.druzhinin;

import java.util.Objects;

public class Triple<T, V, E> extends Pair<T, V> {
    private E third;

    public Triple(T first, V second, E third) {
        super(first, second);
        this.third = third;
    }

    public E getThird() {
        return third;
    }

    public void setThird(E third) {
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(third, triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), third);
    }
}
