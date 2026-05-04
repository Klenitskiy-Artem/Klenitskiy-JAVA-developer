package Lesson17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lesson17 {
    public static void main(String[] args) {

//       Задача 1
//        Пользователь вводит в консоль дату своего рождения. Программа должна вернуть дату,
//        когда пользователю исполнится 100 лет. Использовать Date/Time API

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Введите дату рождения в формате дд.мм.гггг (например: 01.01.1990):");
        String input = scanner.nextLine();

        try {
            LocalDate birthDate = LocalDate.parse(input, formatter);
            LocalDate hundredYearsLater = birthDate.plusYears(100);
            System.out.println("Вам исполнится 100 лет: " + hundredYearsLater.format(formatter));
        } catch (Exception e) {
            System.out.println("Ошибка: неверный формат даты. Пожалуйста, используйте дд.мм.гггг.");
        }

//        Задача 2
//        Используя Predicate среди массива чисел вывести только те, которые являются
//        положительными.

        Integer[] numbers = {5, -3, 10, 0, -1, 7, -15, 20};
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println("Положительные числа из массива:");

        Arrays.stream(numbers)
                .filter(isPositive)
                .forEach(System.out::println);

//        Задача 3
//        Используя Function реализовать лямбду, которая будет принимать в себя строку в
//        формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
//        возвращать сумму, переведенную сразу в доллары.

        double exchangeRate = 2.89;
        Function<String, Double> convertToUsd = inputStr -> {
            String[] parts = inputStr.split(" ");
            double bynAmount = Double.parseDouble(parts[0]);
            return bynAmount / exchangeRate;
        };

        String input3 = "100 BYN";
        Double result3 = convertToUsd.apply(input3);
        System.out.println("Исходная строка: " + input3);
        System.out.printf("Сумма в долларах: %.2f USD%n", result3);

        System.out.println();

//        Задача 4
//        Используя Consumer реализовать лямбду, которая будет принимать в себя строку в
//        формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
//        выводить сумму, переведенную сразу в доллары.

        Consumer<String> convertAndPrint = str -> {
            try {
                String[] parts = str.split(" ");
                double bynAmount = Double.parseDouble(parts[0]);
                double usdAmount = bynAmount / exchangeRate;

                System.out.printf("Результат конвертации для \"%s\": %.2f USD%n", str, usdAmount);
            } catch (Exception e) {
                System.out.println("Ошибка: проверьте формат входной строки (например, '100 BYN')");
            }
        };

        System.out.println("--- Задача 4 (Consumer) ---");
        convertAndPrint.accept("100 BYN");
        convertAndPrint.accept("250.5 BYN");
        convertAndPrint.accept("50 BYN");

//        Задача 5
//        Используя Supplier написать метод, который будет возвращать введенную с консоли
//        строку задом наперед.

        System.out.println("\n--- Задача 5 (Supplier) ---");
        Supplier<String> reverseInputSupplier = () -> {
            System.out.println("Введите строку для инверсии:");
            String textToReverse = scanner.nextLine();
            return new StringBuilder(textToReverse).reverse().toString();
        };

        String reversed = reverseInputSupplier.get();
        System.out.println("Результат: " + reversed);

        scanner.close();

    }
}
