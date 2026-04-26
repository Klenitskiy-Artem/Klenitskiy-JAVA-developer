package Lesson15;

import java.util.LinkedList;

public class AnimalShelter {
    private LinkedList<String> animals = new LinkedList<>();

    public void addAnimal(String name) {
        animals.addFirst(name);
        System.out.println("Добавлено в начало: " + name);
    }

    public String removeAnimal() {
        if (animals.isEmpty()) {
            return "Список пуст, удалять нечего.";
        }
        String removed = animals.removeLast();
        System.out.println("Удалено из конца: " + removed);
        return removed;
    }

    public void displayAnimals() {
        System.out.println("Текущие животные: " + animals);
    }
}