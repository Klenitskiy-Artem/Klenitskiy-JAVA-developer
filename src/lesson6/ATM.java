package lesson6;

public class ATM {
    private int count20;
    private int count50;
    private int count100;

    public ATM(int count20, int count50, int count100) {
        this.count20 = count20;
        this.count50 = count50;
        this.count100 = count100;
    }

    public void addMoney(int c20, int c50, int c100) {
        if (c20 >= 0 && c50 >= 0 && c100 >= 0) {
            this.count20 += c20;
            this.count50 += c50;
            this.count100 += c100;
            System.out.println(">>> Инкассация успешно завершена.");
        } else {
            System.out.println(">>> Ошибка: нельзя добавить отрицательное количество купюр.");
        }
    }

    public boolean withdrawMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: Сумма должна быть положительной.");
            return false;
        }

        for (int i = Math.min(amount / 100, count100); i >= 0; i--) {
            int resAfter100 = amount - (i * 100);
            for (int j = Math.min(resAfter100 / 50, count50); j >= 0; j--) {
                int resAfter50 = resAfter100 - (j * 50);
                if (resAfter50 % 20 == 0) {
                    int k = resAfter50 / 20;
                    if (k <= count20) {
                        count100 -= i;
                        count50 -= j;
                        count20 -= k;
                        System.out.println("Успех! Выдано: [100]x" + i + ", [50]x" + j + ", [20]x" + k);
                        return true;
                    }
                }
            }
        }
        System.out.println("Ошибка: Банкомат не может выдать сумму " + amount + " данными купюрами.");
        return false;
    }

    public void displayStatus() {
        System.out.println("\n--- СОСТОЯНИЕ БАНКОМАТА ---");
        System.out.println("100: " + count100 + " шт. | 50: " + count50 + " шт. | 20: " + count20 + " шт.");
        int total = (count100 * 100) + (count50 * 50) + (count20 * 20);
        System.out.println("Общая сумма: " + total);
        System.out.println("---------------------------\n");
    }
}
