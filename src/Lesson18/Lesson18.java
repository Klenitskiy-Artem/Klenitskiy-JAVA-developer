package Lesson18;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson18 {
    public static void main(String[] args) {
//    Задача 1
//    Создать коллекцию класса ArrayList наполнить ее элементами типа Integer. С помощью
//        Stream'ов:
//        - Удалить дубликаты
//        - Оставить только четные элементы
//        - Вывести сумму оставшихся элементов в стриме

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 8, 10, 10));

        int sum = numbers.stream()
                .distinct()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Сумма уникальных четных элементов: " + sum);

//   Задача *
//   Создать набор данных в формате id-name, сохраненный в Map. Необходимо отобрать из
//        этого набора только те данные, id которых попадает в числовой диапазон 1/2/5/8/9/13.
//        Среди отобранных значений отобрать только те, которые имеют нечетное количество
//        букв в имени. После чего вернуть список List имен, записанных буквами задом наперед.

        Map<Integer, String> data = new HashMap<>();
        data.put(1, "Ivan");
        data.put(2, "Oleg");
        data.put(5, "Anna");
        data.put(8, "Alexey");
        data.put(9, "Dmitry");
        data.put(13, "Artem");
        data.put(3, "Max");
        data.put(5, "Elena");

        Set<Integer> targetIds = Set.of(1, 2, 5, 8, 9, 13);

        List<String> result = data.entrySet().stream()
                .filter(entry -> targetIds.contains(entry.getKey()))
                .filter(entry -> entry.getValue().length() % 2 != 0)
                .map(entry -> new StringBuilder(entry.getValue()).reverse().toString())
                .collect(Collectors.toList());

        System.out.println("Результат: " + result);
    }
}
