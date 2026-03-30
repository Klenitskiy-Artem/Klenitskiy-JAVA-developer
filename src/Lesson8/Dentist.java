package Lesson8;

class Dentist extends Doctor {
    @Override
    public void treat() {
        System.out.println("Дантист: Выбивает зубы и ставит спички.");
    }
}
