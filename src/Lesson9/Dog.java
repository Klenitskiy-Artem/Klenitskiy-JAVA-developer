package Lesson9;

class Dog extends Animal {
    private static Dog instance;

    private Dog() {}

    public static Dog getInstance() {
        if (instance == null) {
            instance = new Dog();
        }
        return instance;
    }

    @Override
    public void voice() { System.out.println("Гав-гав!"); }

    @Override
    public void eat(String food) {
        if (food.equalsIgnoreCase("Meat")) System.out.println("Собака съела мясо.");
        else System.out.println("Собака хочет мясо, а не " + food);
    }
}