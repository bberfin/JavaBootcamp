package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Category> categories = new ArrayList<Category>();
        List<Course> courses = new ArrayList<Course>();
        List<Instructor> instructors = new ArrayList<Instructor>();
        List<Student> students = new ArrayList<Student>();

        Category category = new Category(1, "programlama");

        Instructor instructor1=new Instructor(1, "Engin", "Demiroğ", courses);
        Instructor instructor2=new Instructor(2, "Halit Enes", "Kalaycı", courses);

        categories.add(category);
        instructors.add(instructor1);
        instructors.add(instructor2);

        Course course1 = new Course(1, "Yazılım Geliştirici Yetiştirme Kampı(C# + ANGULAR)", category, instructors, students);
        Course course2 = new Course(2, "Yazılım Geliştirici Yetiştirme Kampı(JAVA + REACT)", category, instructors, students);
        Course course3 = new Course(3, "Yazılım Geliştirici Yetiştirme Kampı(JAVASCRIPT)", category, instructors, students);
        Course course4 = new Course(4, "Yazılım Geliştirici Yetiştirme Kampı(.NET)", category, instructors, students);
        Course course5 = new Course(5, "Yazılım Geliştirici Yetiştirme Kampı(JAVA)", category, instructors, students);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);

        for (Course course:courses)
            System.out.println(course.toString());

    }
}
