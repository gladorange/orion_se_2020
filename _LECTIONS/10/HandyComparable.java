public  interface HandyComparable<T>  extends Comparable<T> {

    default boolean isGreater(T another) {
        return compareTo(another) > 0;
    }

    default boolean isLower(T another) {
        return compareTo(another) < 0;
    }

    default boolean isEqual(T another) {
        return compareTo(another) == 0;
    }


    public static class Person implements HandyComparable<Person> {


        String name;
        int age;


        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person another) {
            return age - another.age;
        }
    }


    public static void main(String[] args) {
        Person vasya = new Person("Vasya", 22);
        Person petya = new Person("Vasya", 23);
        Person masha = new Person("Masha", 18);


        System.out.println(vasya.isGreater(masha));
        System.out.println(vasya.isLower(petya));
    }

}
