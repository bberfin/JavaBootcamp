package org.example;

import java.util.List;

public class Course {

    private long id;
    private String name;
    private Category category;
    private List<Instructor> instructors;
    private List<Student> students;

    public Course(long id, String name, Category category, List<Instructor> instructors, List<Student> students) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.instructors = instructors;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category.getName() +
                ", instructors=" + instructors +
                ", students=" + students+
                '}';
    }
}
