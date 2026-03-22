package lesson7;

/**
 * Klenitskiy Atrem
 * changed 02/03/2026
 * */

public class Lesson7 {
    public static void main(String[] args) {
//        Задача 1
//        Создать классы "Директор", "Рабочий", "Бухгалтер". Реализовать интерфейс с методом,
//        который печатает название должности и имплементировать метод в созданные классы

        Director director = new Director();
        Worker worker = new Worker();
        Accountant accountant = new Accountant();

        Position[] employees = {director, worker, accountant};

        System.out.println("--- Список должностей в компании ---");

        for (Position employee : employees) {
            employee.printPosition();
        }
//        Задача 2
//        Написать иерархию классов Фигура, Треугольник, Прямоугольник, Круг. Реализовать
//        функцию подсчета площади для каждого типа фигуры и подсчет периметра(используя
//        абстрактный класс/методы). Создать массив из 5 разных фигур. Вывести на экран сумму
//        периметра всех фигур в массиве

        Figure[] figures = new Figure[5];
        figures[0] = new Triangle(3, 4, 5);
        figures[1] = new Rectangle(10, 20);
        figures[2] = new Circle(5);
        figures[3] = new Rectangle(5, 5);
        figures[4] = new Circle(10);

        double totalPerimeter = 0;

        System.out.println("--- Информация о фигурах ---");
        for (Figure f : figures) {
            System.out.printf("Фигура: %s | Периметр: %.2f | Площадь: %.2f%n",
                    f.getClass().getSimpleName(), f.getPerimeter(), f.getArea());

            totalPerimeter += f.getPerimeter();
        }

        System.out.println("-----------------------------");
        System.out.printf("Сумма периметров всех фигур в массиве: %.2f%n", totalPerimeter);

//        Задача *
//       Самостоятельно изучить и показать пример работы интерфейса-маркера Cloneable.
        try {
            Car originalCar = new Car("Tesla Model 3", 2024);

            Car clonedCar = (Car) originalCar.clone();

            System.out.println("--- Оригинал ---");
            originalCar.displayInfo();

            System.out.println("--- Клон ---");
            clonedCar.displayInfo();

            System.out.println("\nЭто разные объекты? " + (originalCar != clonedCar));

        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирование не поддерживается!");
            e.printStackTrace();
        }
    }
}
