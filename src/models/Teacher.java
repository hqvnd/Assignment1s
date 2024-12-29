package models;

public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public int giveRaise(int a){
        double persent = (a / 100.0) * salary;
        salary += persent;
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
}
