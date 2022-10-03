package entity;

import java.math.BigDecimal;

public class Teacher {
    private int id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private University university;

    public Teacher() {
    }

    public Teacher(int id, String name, String surname, University university) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "entity.Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
