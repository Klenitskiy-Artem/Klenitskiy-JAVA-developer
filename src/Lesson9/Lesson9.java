package Lesson9;

public class Lesson9 {
    public static void main(String[] args) {
//Создать логически верную иерархию следующих классов: Animal, Dog, Tiger, Rabbit.
//        Переопределить методы voice(), eat(String food) чтобы они выводили верную
//информацию. Метод eat может принимать “Meat”, “Grass” и другие строки.
//        Например, еслки мы создадим объет класса Rabbit, вызовем метод eat() и передадим
//туда “Grass” он должен написать в консоли что любит есть травку. Если передадим “Meat” или другую строку то он будет недоволен.

        Animal myTiger = new Tiger();
        Animal myRabbit = new Rabbit();

        System.out.println("--- Проверка Кролика ---");
        myRabbit.voice();
        myRabbit.eat("Grass");
        myRabbit.eat("Meat");

        System.out.println("\n--- Проверка Тигра ---");
        myTiger.voice();
        myTiger.eat("Meat");
        myTiger.eat("Grass");

//    Задача *:
//    Написать такой конструктор, который запретит создание объекта класса Dog в других
//            классах; Найти способ вызывать методы voice(), eat() класса Dog, который позволит
//    обойти ограничение, наложенное конструктором выше. Объяснить, как работают оба
//    способа.

        Dog specialDog = Dog.getInstance();

        System.out.println("--- Проверка Singleton Dog ---");
        specialDog.voice();
        specialDog.eat("Meat");
        specialDog.eat("Grass");

        Dog anotherDogReference = Dog.getInstance();
        System.out.println("Это один и тот же объект? " + (specialDog == anotherDogReference));

    }
}
