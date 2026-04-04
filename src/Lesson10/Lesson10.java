package Lesson10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson10 {
    public static void main(String[] args) {

//        Задача 1
//        Создать класс для описания пользователя системы. Переопределить в классе методы
//        toString,hashcode и equals. Создать несколько экземпляров класса с одним и тем же
//        значением полей и сравнить с помощью метода equals.


        User userA = new User(1, "Ivan", new Settings("Light"));
        User userB = new User(1, "Ivan", new Settings("Light"));

        System.out.println("Сравнение одинаковых объектов:");
        System.out.println("userA equals userB: " + userA.equals(userB));
        System.out.println("Хеш-коды равны: " + (userA.hashCode() == userB.hashCode()));
        System.out.println("--------------------------------------\n");

//        Задача *
//        Создать программу для реализации поверхностного и глубокого клонирования объекта
//        класса User. Пусть на вход программе будет передаваться тип операции клонирования
//                (поверхностное клонирование или глубокое), а также id юзера для клонирования.

        // 2. Подготовка "базы данных" для клонирования
        Map<Integer, User> db = new HashMap<>();
        db.put(1, userA);
        db.put(2, new User(2, "Anna", new Settings("Dark")));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID юзера (1 или 2): ");
        int id = scanner.nextInt();

        System.out.print("Тип клонирования (1 - Поверхностное, 2 - Глубокое): ");
        int type = scanner.nextInt();

        User original = db.get(id);
        if (original == null) {
            System.out.println("Пользователь не найден.");
            return;
        }

        try {
            User clone;
            if (type == 1) {
                clone = original.shallowCopy();
                System.out.println("Выполнено поверхностное клонирование.");
            } else {
                clone = original.deepCopy();
                System.out.println("Выполнено глубокое клонирование.");
            }

            // Демонстрация разницы клонирования
            System.out.println("До изменения: ");
            System.out.println("Оригинал: " + original);
            System.out.println("Клон:     " + clone);

            System.out.println("\nМеняем тему в КЛОНЕ на 'Neon'...");
            clone.setTheme("Neon");

            System.out.println("После изменения: ");
            System.out.println("Оригинал: " + original);
            System.out.println("Клон:     " + clone);

            // Итоговая проверка
            if (original.getSettings() == clone.getSettings()) {
                System.out.println("\nРезультат: Поля 'settings' ссылаются на ОДИН объект (Side effect!)");
            } else {
                System.out.println("\nРезультат: Поля 'settings' независимы.");
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

