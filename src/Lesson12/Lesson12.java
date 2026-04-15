package Lesson12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson12 {
    public static void main(String[] args) {

//    Задача 1
//    Вывести в консоль из строки которую пользователь вводит с клавиатуры все
//    аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
//    только из прописных букв, без чисел.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine();

        String regex = "\\b[A-ZА-ЯЁ]{2,6}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        System.out.println("Найденные аббревиатуры:");
        boolean found = false;

        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Аббревиатуры не найдены.");
        }
//     Задача *
//      Программа на вход получает произвольный текст. В этом тексте может быть номер
//        документа(один или несколько), емейл и номер телефона. Номер документа в формате: xxxx-xxxx-xx, где x - это любая цифра;
//        номер телефона в формате: +(xx)xxxxxxx. Документ может содержать не всю информацию, т.е. например, может не содержать номер телефона, или другое.
//        Необходимо найти эту информацию и вывести в консоль в формате:
//        email: teachmeskills@gmail.com
//        document number: 1423-1512-51
//        и т.д
        String text = "Привет! Мне написали с email: teachmeskills@gmail.com, там был номер документа 1423-1512-51. " +
                "Также попросили связаться по телефону +(29)5291111 или по доп. номеру +(29)5556677.";

        Pattern docPattern = Pattern.compile("\\b\\d{4}-\\d{4}-\\d{2}\\b");

        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");

        Pattern phonePattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");

        extractAndPrint(text, emailPattern, "email");
        extractAndPrint(text, docPattern, "document number");
        extractAndPrint(text, phonePattern, "phone number");
    }

    private static void extractAndPrint(String text, Pattern pattern, String label) {
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(label + ": " + matcher.group());
        }
    }
}
