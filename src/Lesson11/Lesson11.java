package Lesson11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lesson11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[3];

        System.out.println("Введите 3 строки:");
        for (int i = 0; i < 3; i++) {
            strings[i] = scanner.nextLine();
        }

//        Задача 1
//        Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести
//        найденные строки и их длину.

        String shortest = strings[0];
        String longest = strings[0];
        for (String s : strings) {
            if (s.length() < shortest.length()) shortest = s;
            if (s.length() > longest.length()) longest = s;
        }
        System.out.println("\n1. Самая короткая: \"" + shortest + "\" (длина: " + shortest.length() + ")");
        System.out.println("   Самая длинная: \"" + longest + "\" (длина: " + longest.length() + ")");

//        Задача 2
//        Ввести 3 строки с консоли. Упорядочить и вывести строки в порядке возрастания
//        значений их длины.

        String[] sortedStrings = strings.clone();
        Arrays.sort(sortedStrings, Comparator.comparingInt(String::length));
        System.out.println("\n2. Строки в порядке возрастания длины:");
        for (String s : sortedStrings) {
            System.out.println("   " + s + " (длина: " + s.length() + ")");
        }

//        Задача 3
//        Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше
//        средней, а также их длину.

        double averageLength = 0;
        for (String s : strings) {
            averageLength += s.length();
        }
        averageLength /= strings.length;
        System.out.println("\n3. Средняя длина: " + averageLength + ". Строки меньше средней:");
        for (String s : strings) {
            if (s.length() < averageLength) {
                System.out.println("   " + s + " (длина: " + s.length() + ")");
            }
        }

//        Задача 4
//        Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
//        Если таких слов несколько, найти первое из них.

        System.out.println("\n4. Поиск слова с уникальными символами:");
        boolean foundUnique = false;
        outerLoop:
        for (String line : strings) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (hasUniqueChars(word)) {
                    System.out.println("   Первое слово с уникальными символами: " + word);
                    foundUnique = true;
                    break outerLoop;
                }
            }
        }
        if (!foundUnique) System.out.println("   Таких слов не найдено.");

//        Задача 5
//        Вывести на консоль новую строку, которой задублирована каждая буква из
//        начальной строки. Например, "Hello" -> "HHeelllloo".

        System.out.println("\n5. Строки с дублированием букв:");
        for (String s : strings) {
            StringBuilder doubled = new StringBuilder();
            for (char ch : s.toCharArray()) {
                doubled.append(ch).append(ch);
            }
            System.out.println("   " + doubled.toString());
        }
//        Задача *
//        Дана строка произвольной длины с произвольными словами. Написать программу для
//        проверки является ли любое выбранное слово в строке палиндромом.
//        Например, есть строка, вводится число 3, значит необходимо проверить является ли 3-е слово в этой строке палиндромом.
//        Предусмотреть предупреждающие сообщения на случаи ошибочных ситуаций: например, в строке 5 слов, а на вход программе передали число 500.

System.out.println("\n--- Проверка слова на палиндром ---");
        System.out.println("Введите новую строку:");
    String input = scanner.nextLine();

    String[] wordsForPalindrome = input.trim().split("\\s+");
        System.out.print("Введите номер слова для проверки (от 1 до " + wordsForPalindrome.length + "): ");

        if (scanner.hasNextInt()) {
        int index = scanner.nextInt();
        try {
            String target = wordsForPalindrome[index - 1];
            if (isPalindrome(target)) {
                System.out.println("Результат: Слово \"" + target + "\" — палиндром.");
            } else {
                System.out.println("Результат: Слово \"" + target + "\" — не палиндром.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: В строке всего " + wordsForPalindrome.length +
                    " слов(а), а вы выбрали " + index + ".");
        }
    } else {
        System.err.println("Ошибка: необходимо ввести целое число.");
    }
}

private static boolean hasUniqueChars(String word) {
    if (word.isEmpty()) return false;
    for (int i = 0; i < word.length(); i++) {
        for (int j = i + 1; j < word.length(); j++) {
            if (word.charAt(i) == word.charAt(j)) return false;
        }
    }
    return true;
}

public static boolean isPalindrome(String s) {
    String clean = s.toLowerCase();
    return clean.equals(new StringBuilder(clean).reverse().toString());
}
}

