package Lesson14;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lesson14 {
    public static void main(String[] args) {
//    Задача 1
//    В задании приложен файл Ромео и Джульетта на английском, вычитать его в приложении. Проанализировать и записать в другой файл самое длинное слово
        String inputPath = "romeo_and_juliet.txt"; // Путь к исходному файлу
        String outputPath = "longest_word.txt";    // Путь к файлу с результатом

        try {
            // 1. Читаем весь текст из файла
            String content = Files.readString(Paths.get(inputPath));

            // 2. Очищаем текст от пунктуации и делим на слова
            // Регулярное выражение [^a-zA-Z]+ оставляет только латинские буквы
            String longestWord = Arrays.stream(content.split("[^a-zA-Z]+"))
                    .max(Comparator.comparingInt(String::length))
                    .orElse("");

            // 3. Записываем результат в новый файл
            if (!longestWord.isEmpty()) {
                Files.writeString(Paths.get(outputPath), longestWord);
                System.out.println("Самое длинное слово найдено и записано: " + longestWord);
                System.out.println("Длина: " + longestWord.length());
            } else {
                System.out.println("Слова не найдены.");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
//     Задание *
//     Допустим есть txt файл с номерами документов. Номером документа является строка,
//        состоящая из букв и цифр(без служебных символов). Пусть этот файл содержит каждый номер
//        документа с новой строки и в строке никакой другой информации, только номер документа.
//        Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности
//        docnum(далее любая последовательность букв/цифр) или contract(далее любая последовательность букв/цифр).
//        Написать программу для чтения информации из входного файла - путь к входному файлу должен задаваться через консоль.
//        Программа должна проверять номера документов на валидность. Валидные номера документов следует записать в один файл-отчет.
//        Невалидные номера документов следует записать в другой файл-отчет, но после
//        номеров документов следует добавить информацию о том, почему этот документ не валиден.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к входному файлу: ");
        String inputPathStr = scanner.nextLine();

        Path inputPath2 = Paths.get(inputPathStr);
        Path validReport = Paths.get("valid_report.txt");
        Path invalidReport = Paths.get("invalid_report.txt");

        if (!Files.exists(inputPath2)) {
            System.err.println("Файл не найден по указанному пути!");
            return;
        }

        try (BufferedWriter validWriter = Files.newBufferedWriter(validReport);
             BufferedWriter invalidWriter = Files.newBufferedWriter(invalidReport)) {

            Files.lines(inputPath2).forEach(line -> {
                String doc = line.trim();
                if (doc.isEmpty()) return;

                String errorReason = validateDocument(doc);

                try {
                    if (errorReason == null) {
                        validWriter.write(doc);
                        validWriter.newLine();
                    } else {
                        invalidWriter.write(doc + " — " + errorReason);
                        invalidWriter.newLine();
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка при записи: " + e.getMessage());
                }
            });

            System.out.println("Обработка завершена.");
            System.out.println("Валидные номера: " + validReport.toAbsolutePath());
            System.out.println("Невалидные номера: " + invalidReport.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
    private static String validateDocument(String doc) {
        if (doc.length() != 15) {
            return "длина не равна 15 символам (текущая: " + doc.length() + ")";
        }

        if (!(doc.startsWith("docnum") || doc.startsWith("contract"))) {
            return "номер не начинается с 'docnum' или 'contract'";
        }

        if (!doc.matches("^[a-zA-Z0-9]+$")) {
            return "содержит служебные символы (разрешены только буквы и цифры)";
        }

        return null;
    }
}