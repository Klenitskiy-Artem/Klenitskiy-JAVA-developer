import java.util.Arrays;
import java.util.Scanner;

/**
 * Klenitskiy Atrem
 * changed 02/03/2026
 * */

public class Lesson4 {
    public static void main(String[] args) {
//        Для всех задач исходные условия следующие: пользователь с клавиатурой вводит размер
//        массива (просто подразумевает число). После того, как задан размер массива, заполните его
//        одним из двух способов: с помощью Math.random(), или каждый элемент массива вводится
//        вручную. Попробовать оба партнера. После увеличения массива
//        данные, решить для него следующую задачи:

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива!\n");
        while (!scanner.hasNextInt()) {
            System.out.println("Мб целое число напишем?");
            scanner.next();
        }
        int a = scanner.nextInt();
        if (a < 0) a = 0;
        int[] array = new int[a];

        int choice = 0;
        while (true) {
            System.out.println("Выберите способ заполнения 1 - 2:");
            System.out.println("1 - Рандомайзер");
            System.out.println("2 - Ручками");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) break;
            } else {
                scanner.next();
            }
            System.out.println("А ну-ка введи именно 1 или 2!");
        }
        if (choice == 1) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100);
            }
            System.out.println("Заполнился рандомайзером.");
        }
        if (choice == 2) {
            System.out.println("Введите\s" + a + "\sчисела(о):");
            for (int i = 0; i < array.length; i++) {
                while (!scanner.hasNextInt()) {
                    System.out.println("А нука по новой! [" + i + "]:");
                    scanner.next();
                }
                array[i] = scanner.nextInt();
            }
        }
        System.out.println("Что у нас вышло:\s" + Arrays.toString(array));

//        Задача 1:
//        Пройдите по массиву, выведите все элементы в прямом и обратном порядке.

        System.out.println("Элементы в прямом порядке:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.println("Элементы в обратном порядке:");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

//        Задача 2 и 3
//Найти минимальный-максимальный элементы и вывести в консоль
//Найдите индексы минимального и максимального элементов и выведите в консоль

        if (array.length > 0) {
            int min = array[0];
            int max = array[0];
            int minIndex = 0;
            int maxIndex = 0;

            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                    minIndex = i;
                }
                if (array[i] > max) {
                    max = array[i];
                    maxIndex = i;
                }
            }
            System.out.println("Базовый минимум: " + min + "\sИндекс минимум\s" + minIndex);
            System.out.println("Раскошный максимум: " + max + "\sИндекс максимум\s" + maxIndex);
        }

// Задача 4
//Найдите и выведите количество нулевых элементов. Если нулевых элементов нет - вывести
//сообщение, что их нет

        int zeroCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeroCount++;
            }
        }
        if (zeroCount > 0) {
            System.out.println("Количество нулей:\s" + zeroCount);
        } else {
            System.out.println("Сегодня без 0.");
        }

// Задача 5
//Пройти по массиву и поменять местами элементы первый и последний, второй и
//предпоследний и т.д.

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            int rightIndex = array.length - 1 - i;
            array[i] = array[rightIndex];
            array[rightIndex] = temp;
        }
        System.out.println("Разворот на 180:\s" + Arrays.toString(array));

// Задача 6
//Проверьте, является ли массив возрастающей последовательностью (каждое следующее число больше предыдущего)

        boolean isIncreasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                isIncreasing = false;
                break;
            }
        }
        if (isIncreasing && array.length > 1) {
            System.out.println("Маленький растет.");
        } else if (array.length <= 1) {
            System.out.println("Нет чему расти.");
        } else {
            System.out.println("Маленький не растет.");
        }

//Задача *
//Имеется массив из неотрицательных чисел(любой). Представьте себе, что массив
//значение числа (Например массив {1,2,3} -> 123, {9,9,9} -> 999). мир
//Добавьте единицу к этому «числу» и на выходе получите исправленный массив. Массив не
//содержит ноль в начале, кроме самого числа 0.

        System.out.print("Введите размер массива!\n");
        while (!scanner.hasNextInt()) {
            System.out.println("Мб целое число напишем?");
            scanner.next();
        }
        int size = scanner.nextInt();
        if (size <= 0) {
            System.out.println("Давай по новой.");
            return;
        }
        int[] digits = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Введите нечетную цифру\s" + i + ":\s");
            int input = scanner.nextInt();

            if (input % 2 != 0 && input >= 0 && input <= 9) {
                digits[i] = input;
            } else {
                System.out.println("ТАК-С.Нужно нечетное число.Давай по новой.");
                i--;
            }
        }
        System.out.println("До прибавления: " + Arrays.toString(digits));
        boolean carry = true;
        for (int i = size - 1; i >= 0 && carry; i--) {
            digits[i]++;
            if (digits[i] <= 9) {
                carry = false;
            } else {
                digits[i] = 0;
            }
        }
        if (carry) {
            int[] newResult = new int[size + 1];
            newResult[0] = 1;
            System.out.println("После +1: " + Arrays.toString(newResult));
        }
        else {
            System.out.println("После +1: " + Arrays.toString(digits));
        }
    }
}


