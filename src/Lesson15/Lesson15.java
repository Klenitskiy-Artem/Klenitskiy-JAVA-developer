package Lesson15;

import java.util.*;

public class Lesson15 {
    public static void main(String[] args) {
//   Задание 1
//        Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
//        4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
//        При решении использовать коллекции.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числа через запятую (например: 1, 2, 2, 3):");
        String input = scanner.nextLine();

        String[] parts = input.split("\\s*,\\s*");

        Set<String> uniqueElements = new LinkedHashSet<>(Arrays.asList(parts));

        String result = String.join(", ", uniqueElements);

        System.out.println("Результат без повторов:");
        System.out.println(result);

//   Задание 2
//        Создать класс, который будет хранить в себе коллекцию с названиями животных.
//        Реализовать методы удаления и добавления животных по следующим правилам:
//        добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
//        объекта этого класса в main методе другого класса.

        AnimalShelter shelter = new AnimalShelter();

        shelter.addAnimal("Лев");
        shelter.addAnimal("Тигр");
        shelter.addAnimal("Слон");
        shelter.displayAnimals();

        shelter.removeAnimal();
        shelter.displayAnimals();

        shelter.addAnimal("Панда");
        shelter.displayAnimals();

        shelter.removeAnimal();
        shelter.displayAnimals();

//   Задание 3
//        Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
//        оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
//        Написать метод, который удаляет студентов со средним баллом <3. Если средний
//        балл>=3, студент переводится на следующий курс. Дополнительно написать метод
//        printStudents(List<Student> students, int course), который получает список студентов и
//        номер курса. А также печатает на консоль имена тех студентов из списка, которые
//        обучаются на данном курсе.

        List<Student> students = new ArrayList<>();
        students.add(new Student("Джек Потрошитель", "А-1", 1, Arrays.asList(4, 5, 3)));
        students.add(new Student("Капитан Джек Воробей", "Б-2", 2, Arrays.asList(2, 3, 2)));
        students.add(new Student("Меченый Стрелок", "А-1", 1, Arrays.asList(5, 5, 5)));
        students.add(new Student("Алексей Сидорович", "В-3", 3, Arrays.asList(3, 3, 4)));

        System.out.println("--- Список до обработки ---");
        students.forEach(System.out::println);

        processStudents(students);

        System.out.println("\n--- Список после обработки (отсеивание и перевод) ---");
        students.forEach(System.out::println);

        System.out.println("\n--- Студенты на 2 курсе ---");
        printStudents(students, 2);
    }

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            } else {
                student.nextCourse();
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }

//   Задание *
//   Представим, что в Java нет коллекции типа ArrayList. Создать свой класс, симулирующий
//        работу класса динамической коллекции - т.е. создать свою кастомную коллекцию. В
//        основе коллекции будет массив. Кастомная коллекция должна хранить элементы разных
//        классов(т.е. это generic).
//        Предусмотреть операции(методы):
//        1. добавления элемента
//        2. удаления элемента
//        3. получение элемента по индексу
//        4. проверка есть ли элемент в коллекции
//        5. очистка всей коллекции
//        Предусмотреть конструктор без параметров - создает массив размером
//        по умолчанию. Предусмотреть конструктор с задаваемым размером внутреннего
//        массива. Предусмотреть возможность автоматического расширения коллекции при
//        добавлении элемента в том случае, когда коллекция уже заполнена.

        System.out.println("");
        MyArrayList<Object> list = new MyArrayList<>(2);
        list.add("Java");
        list.add("Kotlin");
        list.add("Python");

        System.out.println("Содержит Kotlin? " + list.contains("Kotlin"));
        System.out.println("Элемент под индексом 1: " + list.get(1));

        list.remove(1);
        System.out.println("После удаления: " + list.get(1));
    }
}
