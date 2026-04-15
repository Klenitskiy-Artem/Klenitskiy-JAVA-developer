package Lesson13;

public class Lesson13 {
    public static void main(String[] args) {
//   Задание1
//   Создать класс, в котором будет статический метод. Этот метод принимает на вход три
//   параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
//   login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
//   соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
//   password должна быть меньше 20 символов, не должен содержать пробелов и должен содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
//   Если password не соответствует этим требованиям, необходимо выбросить
//   WrongPasswordException. WrongPasswordException и WrongLoginException -
//   пользовательские классы исключения с двумя конструкторами – один по умолчанию,
//   второй принимает сообщение исключения и передает его в конструктор класса Exception.
//   Метод возвращает true, если значения верны, false в противном случае.
        try {
            boolean isValid = Сonfidentially.checСonfidentially("Volodya", "12345228", "12345228");
            if (isValid) {
                System.out.println("Регистрация успешна!");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("В доступе отказано: данные некорректны.");
        }
//    Задание*
//    Написать try/catch/finally, в котором finally вызван не будет.
        try {
            System.out.println("Бэнг try");
            int result = 10 / 0;
            System.exit(0);

        } catch (ArithmeticException e) {
            System.out.println("Бэнг");
            System.exit(0);

        } finally {
            System.out.println("Этот текст никогда не напечатается");
        }
    }
}
