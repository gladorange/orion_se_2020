package com.orion.lesson7;

public class IdentityExample {



    static class  MyClass {
      /*  @Override
        public int hashCode() {
            return 42;
        }*/
    }

    public static void main(String[] args) {

        MyClass cl = new MyClass();

        System.out.println(cl.hashCode());
        System.out.println(System.identityHashCode(cl));
    }
}
