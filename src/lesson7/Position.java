package lesson7;

public interface Position {
    void printPosition();
}

class Director implements Position {
    @Override
    public void printPosition() {
        System.out.println("Должность: Директор");
    }
}

class Worker implements Position {
    @Override
    public void printPosition() {
        System.out.println("Должность: Рабочий");
    }
}

class Accountant implements Position {
    @Override
    public void printPosition() {
        System.out.println("Должность: Бухгалтер");
    }
}
