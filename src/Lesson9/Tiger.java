package Lesson9;

class Tiger extends Animal {
    @Override
    public void voice() {
        System.out.println("Тигр: Ррррр!");
    }

    @Override
    public void eat(String food) {
        if (food.equalsIgnoreCase("Meat")) {
            System.out.println("Тигр: Вот это пруха джонни - это мясо для гурманов");
        } else {
            System.out.println("Тигр: Я не ем " + food + "! Мне нужно только мясо.");
        }
    }
}