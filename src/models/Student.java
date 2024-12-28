package models;

import java.util.ArrayList;

public class Student extends Person {
    private static int idCounter = 1; // counter i guess
    private int studentID;
    private ArrayList<Integer> grades;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Grade must be between 0 and 100.");
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }

    public int getStudentID() { return studentID; }

    public ArrayList<Integer> getGrades() { return grades; }
}
