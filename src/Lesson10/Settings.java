package Lesson10;

class Settings implements Cloneable {
    String theme;

    public Settings(String theme) { this.theme = theme; }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() { return "{theme='" + theme + "'}"; }
}
