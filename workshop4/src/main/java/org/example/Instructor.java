package org.example;

import java.util.List;

public class Instructor extends User {

    List<Course> courses;

    public Instructor(long id, String firstName, String lastName, List<Course> courses) {
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
