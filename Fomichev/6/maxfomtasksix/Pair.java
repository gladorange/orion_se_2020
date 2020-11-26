package maxfomtasksix;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Pair <T, U> {

    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public <T> Pair(List<T> asList) {
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static void main(String[] args) {
        Pair<String, Integer> lastNameToAge = new Pair<>("Пупкин", 18);
        String lastName = lastNameToAge.getFirst();
        Integer age = lastNameToAge.getSecond();

        Pair<String, List<String>> lastNameToPhoneNumbers = new Pair<>("Пупкин", Arrays.asList("+7 831 2112233", "+7 920 000 22 22"));
        String surName = lastNameToPhoneNumbers.getFirst();
        List<String> phoneNumbers = lastNameToPhoneNumbers.getSecond();

        System.out.println(lastNameToAge);
        System.out.println(lastNameToPhoneNumbers);
    }

}
