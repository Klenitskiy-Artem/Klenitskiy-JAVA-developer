package Lesson8;

class Surgeon extends Doctor {
    @Override
    public void treat() {
        System.out.println("Хирург: Проводит операцию по удалению правого яичка.");
    }
}
