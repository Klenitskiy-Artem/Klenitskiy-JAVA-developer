package lesson7;

class Car implements Cloneable {
    String model;
    int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void displayInfo() {
        System.out.println("Машина: " + model + ", Год: " + year);
    }
}
