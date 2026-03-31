package Lesson9;

class Rabbit extends Animal {
    @Override
    public void voice() {
        System.out.println("Кролик: Фыр-фыр (хрустит носом)");
    }

    @Override
    public void eat(String food) {
        if (food.equalsIgnoreCase("Grass")) {
            System.out.println("Кролик: Хрум-хрум, очень вкусная травка!");
        } else {
            System.out.println("Кролик: Фу, я не буду есть " + food + ". Дайте морковку или траву!");
        }
    }
}
