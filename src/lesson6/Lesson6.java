package lesson6;
import java.util.Scanner;

public class Lesson6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Задание 1
//        Создать класс CreditCard c полем номера счета, текущая часть по счету. добавить
//        метод, который позволяет вычислить сумму по кредитной карте. добавить метод,
//        который позволяет снять с карточек некоторую сумму. добавьте метод, который
//        выводит текущую информацию о карточке. Напишите программу, которая производит три
//        объект класса CreditCard, в котором заданы номер счета и начальная стадия.
//                Тестовый сценарий для проверки: Положите деньги на первые две карты и отключите их.
//                остатки. Состояние всех трех карточек.
        CreditCard card1 = new CreditCard("BY01ALPHA123", 100.0);
        CreditCard card2 = new CreditCard("BY02BETA456", 500.0);
        CreditCard card3 = new CreditCard("BY03GAMMA789", 1000.0);

        System.out.print("Введите сумму для ПОПОЛНЕНИЯ первой карты (" + card1.accountNumber + "): ");
        double depAmount1 = scanner.nextDouble();
        card1.deposit(depAmount1);

        System.out.print("Введите сумму для ПОПОЛНЕНИЯ второй карты (" + card2.accountNumber + "): ");
        double depAmount2 = scanner.nextDouble();
        card2.deposit(depAmount2);

        System.out.print("Введите сумму для СНЯТИЯ с третьей карты (" + card3.accountNumber + "): ");
        double withAmount3 = scanner.nextDouble();
        card3.withdraw(withAmount3);

        System.out.println("\n--- Итоговое состояние всех карт ---");
        card1.displayInfo();
        card2.displayInfo();
        card3.displayInfo();

//        Задание *
//        Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
//        задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
//        метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
//        принимает сумму денег, а возвращает булевое значение - успешность выполнения
//        операции. При снятии денег, функция должна распечатывать каким количеством купюр
//        какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
//                количеством купюр каждого номинала

        ATM atm = new ATM(10, 10, 10);
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Снять деньги");
            System.out.println("2. Пополнить банкомат (инкассация)");
            System.out.println("3. Показать остаток");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите сумму для снятия: ");
                    int amount = sc.nextInt();
                    atm.withdrawMoney(amount);
                    break;
                case 2:
                    System.out.print("Купюр по 20: ");
                    int c20 = sc.nextInt();
                    System.out.print("Купюр по 50: ");
                    int c50 = sc.nextInt();
                    System.out.print("Купюр по 100: ");
                    int c100 = sc.nextInt();
                    atm.addMoney(c20, c50, c100);
                    break;
                case 3:
                    atm.displayStatus();
                    break;
                case 0:
                    running = false;
                    System.out.println("Завершение работы...");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        sc.close();
    }
}
