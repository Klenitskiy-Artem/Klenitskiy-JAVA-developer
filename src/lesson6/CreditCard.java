package lesson6;

public class CreditCard {
    String accountNumber;
    double currentBalance;

    // Конструктор для инициализации номера счета и начальной суммы
    public CreditCard(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.currentBalance = initialBalance;
    }

    // Метод для зачисления суммы на карту
    public void deposit(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            System.out.println("Счет " + accountNumber + ": пополнено на " + amount);
        }
    }

    // Метод для снятия суммы с карты
    public void withdraw(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            System.out.println("Счет " + accountNumber + ": снято " + amount);
        } else {
            System.out.println("Счет " + accountNumber + ": недостаточно средств или некорректная сумма.");
        }
    }

    // Метод для вывода текущей информации о карточке
    public void displayInfo() {
        System.out.println("Номер счета: " + accountNumber + " | Текущий баланс: " + currentBalance);
    }
}
