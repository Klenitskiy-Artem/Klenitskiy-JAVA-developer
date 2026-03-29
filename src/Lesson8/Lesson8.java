package Lesson8;

import java.lang.reflect.Field;

public class Lesson8 {
    public static void main(String[] args) {

//        Задание 1
//    Создать программу для имитации работы клиники. Пусть в клинике будет три врача:
//    хирург, терапевт и дантист. Каждый врач имеет метод «лечить», но каждый врач лечит
//    по-своему. Так же предусмотрите класс «Пациент» с полем «План лечения» и полем.
//    «Доктор». Создать объект класса «Пациент» и добавить пациенту план лечения. У
//    терапевта создать метод, который будет назначать врача пациенту согласно плану
//    лечение:
//    Если код плана лечения имеет 1 – назначить хирурга и выполнить метод лечить.
//    Если код плана лечения имеет 2 – назначить дантиста и выполнить метод лечить.
//    Если в плане лечения имеется любой другой код – назначить терапевта и выполнить метод
//    лечить.
        Therapist headTherapist = new Therapist();

        Patient patientA = new Patient(1);
        Patient patientB = new Patient(2);
        Patient patientC = new Patient(5);

        System.out.println("--- Работа клиники началась ---");
        headTherapist.assignDoctor(patientA);
        headTherapist.assignDoctor(patientB);
        headTherapist.assignDoctor(patientC);
        //        Задание *
//     Создать класс Apple и добавить в него поле color с модификатором доступа private и
//        инициализировать его. В методе main другого класса создать объект Apple, и не
//        используя сеттеры изменить значение поля color.
        System.out.println("Задание *");
        try {
            Apple myApple = new Apple();
            System.out.println("Цвет до изменений: " + myApple.getColor());

            Field colorField = myApple.getClass().getDeclaredField("color");

            colorField.setAccessible(true);

            colorField.set(myApple, "Green");

            System.out.println("Цвет после изменений: " + myApple.getColor());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

