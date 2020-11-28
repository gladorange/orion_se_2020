package maxfomtasksix;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Triple<T, U, V> {

    public T first;
    public U second;
    public V third;

    public Triple(T first, U second, V third) {
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

    public V getThird() {
        return third;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(first, triple.first) &&
                Objects.equals(second, triple.second) &&
                Objects.equals(third, triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    public static void main(String[] args) {
        Triple<String, Integer, Character> lastNameAgeGroup = new Triple<>("Антонов", 10,'А');
        String lastName = lastNameAgeGroup.getFirst();
        Integer age = lastNameAgeGroup.getSecond();
        Character group = lastNameAgeGroup.getThird();

        Triple<String, List<String>, Character> surnameToSuccessToGroup = new Triple<>("Барабанов", Arrays.asList("Отличник", "Медалист"),'B');
        String surName = surnameToSuccessToGroup.getFirst();
        List<String> success = surnameToSuccessToGroup.getSecond();
        Character groupSchool = surnameToSuccessToGroup.getThird();

        System.out.println(lastNameAgeGroup);
        System.out.println(surnameToSuccessToGroup);
    }

}
