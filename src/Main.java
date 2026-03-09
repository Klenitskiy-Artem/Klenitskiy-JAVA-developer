import java.util.Scanner;
import java.util.Random;

/**
 * Klenitskiy Atrem
 * changed 02/03/2026
 * */
public class Main {
    public static void main(String[] args) {
        int age = 26;
        System.out.println("Артем Кленицкий\s" + age); // добаввил в ветке тест
        System.out.println("как дела?");

//  Напишите приложение, которое будет рассчитывать и выведите значение по формуле:
// a=4*(b+c-1)/2; b и c задаем в коде самостоятельно.

        int b = 7;
        int c = 3;
        int a = 4 * (b + c - 1) / 2;
        System.out.println("Результат a:\s" + a );

// В переменной n сохраняется двузначное число. разработать программу, резервную и
//выводящую на экран цифру n. Например: n =26, в результате мы должны получить 8
//(2+6)
//
        int n = 26;
        int odin = n / 10;
        int dva = n % 10;
        int sum = odin + dva;
        System.out.println("Сумма цифр числа\s" + n + "\sравна:\s" + sum);

//В переменной n хранится трёхзначное число. Создайте программу, вычисляющую и
//выводящую на экран сумму цифр n. Например: n =126, в результате мы должны получить
//9 (1+2+6)

        int v = 126;
        int tri = v / 100;
        int chet = (v / 10) % 10;
        int pit = v % 10;
        int summ = tri + chet + pit;

        System.out.println("Сумма цифр числа\s" + v + "\sравна:\s" + summ);

        int z = 12634;
        int one = z / 10000;
        int two = (z / 1000) % 10;
        int three = (z / 100) % 10;
        int four = (z / 10) % 10;
        int five = z % 10;
        int summa = one + two + three +four + five;

        System.out.println("Сумма цифр числа\s" + z + "\sравна:\s" + summa);

        long e = 12634298;
        long six = e / 10000000;
        long seven = (e / 1000000) % 10;
        long eight = (e / 100000) % 10;
        long nine = (e / 10000) % 10;
        long ten = (e / 1000) % 10;
        long eleven = (e / 100) % 10;
        long twelve = (e / 10) % 10;
        long thirteen = e % 10;
        long otvet = six + seven + eight +nine + ten + eleven + twelve + thirteen;

        System.out.println("Сумма цифр числа\s" + e + "\sравна:\s" + otvet);

//В переменной n хранится вещественное число с ненулевой дробной частью. Создайте
//программу, округляющую число n до ближайшего целого и выводящую результат на
//экран.

        double y = 7787.5;
        int x = (int)Math.round(y);
        System.out.println("Число которое мы округлили\s" + x + "\sпозвони и мы подбросим");

//        В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую
//        на экран результат деления q на w с остатком. Пример вывода программы (для случая,
//                когда в q хранится 21, а в w хранится 8): 21 / 8 = 2 и 5 в остатке.

        int i = 99;
        int p = 13;
        int o = i / p ;
        int s = i % p ;
        System.out.println("Результат деления\s" + o + "\sостаток\s" + s + "\sбазовых велечин");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 число:");
        int k = scanner.nextInt();
        System.out.println("Введите 2 число:");
        int l = scanner.nextInt();;
        int q = k;
        k = l;
        l = q;
        System.out.println("Поменялись " + k);
        System.out.println("Поменялись " + l);

    }
}

