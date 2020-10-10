package maxfom;
/**
 * 2. Написать программу, в которой есть две переменные типа Integer со значениями.
 * Значения можно указать в коде программы или ввести с клавиатуры или взять из аргументов.
 * 3. Если первое число больше второго – написать на экран « Число %s больше %s”
 * Если первое число меньше второго – написать на экран «Число %s меньше %s”
 * 4. В любом случае, вывести на экран сумму чисел.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число");
        Integer a = Integer.valueOf(reader.readLine());

        System.out.println("Введите число");
        Integer b = Integer.valueOf(reader.readLine());
        Formatter f = new Formatter();

        if (a > b) {
            f.format("Число %s больше %s", a, b);
            System.out.println(f);
        }
        else if (a < b) {
            f.format("Число %s меньше %s", a, b);
            System.out.println(f);
        }
        else
            System.out.println("Числа равны");

        System.out.println("Сумма введенных чисел - " + sum(a, b));

    }

    static int sum(Integer a, Integer b) {
        return a + b;
    }
}