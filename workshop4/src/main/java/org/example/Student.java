package org.example;

import java.util.List;

public class Student extends User {
    private List<Course> courses;

    public Student(long id, String firstName, String lastName, List<Course> courses) {
        super(id, firstName, lastName);
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


}
