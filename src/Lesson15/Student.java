package Lesson15;

import java.util.List;

class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void nextCourse() {
        this.course++;
    }

    public String getName() { return name; }
    public int getCourse() { return course; }

    @Override
    public String toString() {
        return String.format("Студент: %s, Курс: %d, Средний балл: %.2f", name, course, getAverageGrade());
    }
}
