package Lesson10;

import java.util.Objects;

public class User implements Cloneable {
    private int id;
    private String name;
    private Settings settings;

    public User(int id, String name, Settings settings) {
        this.id = id;
        this.name = name;
        this.settings = settings;
    }

    // --- Переопределение базовых методов ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(settings, user.settings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, settings);
    }

    @Override
    public String toString() {
        return "User[ID=" + id + ", Name='" + name + "', Settings=" + settings + "]";
    }

    // Поверхностное копирование
    public User shallowCopy() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    // Глубокое копирование
    public User deepCopy() throws CloneNotSupportedException {
        User clonedUser = (User) super.clone();
        clonedUser.settings = (Settings) this.settings.clone();
        return clonedUser;
    }

    // Геттеры и сеттеры
    public void setTheme(String theme) { this.settings.theme = theme; }
    public Settings getSettings() { return settings; }
}