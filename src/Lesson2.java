import java.util.Scanner;

/**
 * Klenitskiy Atrem
 * changed 02/03/2026
 *
 */

public class Lesson2 {
    public static void main(String[] args) {

//    Задача 1
//    Напишите программу, которая будет принимать входное число из консоли и на выходе
//    будет выведено сообщение четное число или нет. Для определения четности чисел
//    Получение остатка от деления (операция выглядит так: '% 2').

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите целое число: ");

            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();

                if (a % 2 == 0) {
                    System.out.println("Число " + a + " — четное.");
                } else {
                    System.out.println("Число " + a + " — нечетное.");
                }
                break;
            } else {
                String b = scanner.next();
                System.out.println("Так-с у нас что-то не получается, давай по новой");
            }
        }

//    Задача 2
//    Для введенного числа t (температуры на улице) вывести: Если t>–5, вывести «Теплый».
//    Если –5>= t > –20, вывести «Нормальный». Если –20>= t, вывести «Холод».

        while (true) {
            System.out.print("Введите температуру: ");

            if (scanner.hasNextInt()) {
                int t = scanner.nextInt();

                if (t > 20000) {
                    System.out.println("Ядерка?");
                } else if (t > 40) {
                    System.out.println("Жара");
                } else if (t > 20) {
                    System.out.println("Намана");
                } else if (t > 5) {
                    System.out.println("Ну чёт не очень");
                } else if (t > -5) {
                    System.out.println("Прохладно");
                } else if (t > -20) {
                    System.out.println("Холоднова-то");
                } else if (t < -1000) {
                    System.out.println("Це шо таке?");
                }
                break;

            } else {
                String input = scanner.next();
                System.out.println("Бэм: " + input + " что-то пошло не так.");
            }
        }

//    Задача 3:
//    Составьте программу, выводящую на экран квадраты чисел от 10 до 20 последовательно.

        System.out.println("Квадраты чисел от 10 до 20:");
        for (int d = 10; d <= 20; d++) {
            int i = d * d; // Вычисляем квадрат
            System.out.println(d + " в квадрате = " + i);
        }

//    Задача 4:
//    Необходимо, чтобы программа вывела на экран такую последовательность:
//    7 14 21 28 35 42 49 56 63 70 77 84 91 98. Включите цикл while.

        System.out.println("Последовательность:");
        int f = 7;
        while (f <= 98) {
            System.out.print(f + " ");
            f += 7;
        }

//        В запишите программу, где пользователь вводит любое положительное число. А
//Программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
//числа в использовании классом Scanner. Проведите проверку, чтобы пользователь не мог
//вводить некорректированные данн

        int g;
        while (true) {
            System.out.print("\nВведите любое положительное целое число: ");

            if (scanner.hasNextInt()) {
                g = scanner.nextInt();
                if (g > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: число должно быть больше 0.");
                }
            } else {
                String e = scanner.next();
                System.out.println("Ошибка: '" + e + "' не является целым числом.");
            }
        }
        int sum = 0;
        for (int i = 1; i <= g; i++) {
            sum += i;
        }
        System.out.println("Сумма всех чисел от 1 до " + g + " равна: " + sum);
        scanner.close();
    }

}
