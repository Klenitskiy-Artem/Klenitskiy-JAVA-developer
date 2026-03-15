import java.util.Scanner;
import java.util.Random;

public class Leson5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//1.1 Создайте двумерный массив, заполните его случайными числами.
//1.2 Добавьте к каждому последовательному числу, который пользователь будет вводить с консоли.
//1.3 Найти сумму всех полученных элементов и вывести в консоль

        int a = 2;
        int b = 2;
        int[][] matrix = new int[a][b];

        System.out.println("Исходная матрица со случайными числами:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matrix[i][j] = random.nextInt(10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Вводите число для прибавления:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.printf("Введите число для элемента [%d][%d]:\s", i, j);
                int userInput = scanner.nextInt();
                matrix[i][j] += userInput;
            }
        }
        long totalSum = 0;
        System.out.println("Что у нас получилось:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(matrix[i][j] + " ");
                totalSum += matrix[i][j];
            }
            System.out.println();
        }
        System.out.println("Сумма всех элементов массива:\s" + totalSum);

//        Создать программу для раскраски шахматной доски с помощью цикла. Создать
//        двумерный массив String 8х8. С помощью циклов присваивания элементам значений массива
//        B(Черный) или W(Белый).
        String[][] board = new String[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = "W";
                } else {
                    board[i][j] = "B";
                }
            }
        }
        System.out.println("Шахматная доска 8x8:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

// Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой
        System.out.print("Введите значение (n):\s");
        int n = scanner.nextInt();
        System.out.print("Введите значение (m):\s");
        int m = scanner.nextInt();

        int[][] jungle = new int[n][m];
        int currentNumber = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    jungle[i][j] = currentNumber++;
                }
            }
            else {
                for (int j = m - 1; j >= 0; j--) {
                    jungle[i][j] = currentNumber++;
                }
            }
        }
        System.out.println("Массив, заполненный змейкой:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%4d", jungle[i][j]);
            }
            System.out.println();
        }

    }
}
