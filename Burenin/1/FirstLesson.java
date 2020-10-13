import java.util.Scanner;

public class FirstLesson {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите число a: ");
        Integer a = scanner.nextInt();
        System.out.printf("Введите число b: ");
        Integer b = scanner.nextInt();

        if (a > b) {
            System.out.println(String.format("Число %s больше %s", a, b));
        } else if (a < b) {
            System.out.println(String.format("Число %s меньше %s", a, b));
        }

        System.out.println(String.format("Сумма чисел: %s", a + b));
    }
}
