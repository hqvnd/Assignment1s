import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Student;
import models.School;
import models.Teacher;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        List<Teacher> teachers;
        teachers = readTeachers("C:\\Users\\Admin\\IdeaProjects\\Assignment1prog\\src\\teachers.txt");
        for (Teacher teacher : teachers) {
            school.addMember(teacher);
        }

        List<Student> students;
        students = readStudents("C:\\Users\\Admin\\IdeaProjects\\Assignment1prog\\src\\students.txt");
        for (Student student : students) {
            school.addMember(student);
        }

        System.out.println(school);

        for (Student student : students) {
            System.out.println("Student: " + student.getName() + " " + student.getSurname());
            System.out.println("GPA: " + student.calculateGPA());
            System.out.println();
        }

        for (Teacher teacher : teachers) {
            if (teacher.getYearsOfExperience() > 10) {
                teacher.giveRaise(10);
                System.out.println("Teacher: " + teacher.getName() + " " + teacher.getSurname());
                System.out.println("New Salary: " + teacher.getSalary());
                System.out.println();
            }
        }
    }

    private static List<Teacher> readTeachers(String filePath) {
        List<Teacher> teachers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equals("Male");
                String subject = parts[4];
                int yearsOfExperience = Integer.parseInt(parts[5]);
                int salary = Integer.parseInt(parts[6]);
                teachers.add(new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    private static List<Student> readStudents(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equals("Male");
                Student student = new Student(name, surname, age, gender);
                for (int i = 4; i < parts.length; i++) {
                    student.addGrade(Integer.parseInt(parts[i]));
                }
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
} //  did buffReader with AI and StackOverflow, sorry :,(