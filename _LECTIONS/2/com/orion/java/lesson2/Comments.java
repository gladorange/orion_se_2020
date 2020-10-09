package com.orion.java.lesson2;

public class Comments {



    class Animal {
        String food;
        String name;


        /**
         * Класс животное
         * @param food любимая еда животного
         * @param name имя животного
         */
        public Animal(String food, String name) {
            this.food = food;
            this.name = name;
        }


        /**
         *
         * @return имя животного
         */
        public String getName() {
            return name;
        }
    }



    public static void main(String[] args) {
        int a = 1;// это - один

        /* а

        это
        многострочный комментарий

         */
    }
}
