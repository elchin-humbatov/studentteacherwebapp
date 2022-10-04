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

    public Teacher(int id, String name, BigDecimal salary, String surname, University university) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.surname = surname;
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public Teacher setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Teacher setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Teacher setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public University getUniversity() {
        return university;
    }

    public Teacher setUniversity(University university) {
        this.university = university;
        return this;
    }

    @Override
    public String toString() {
        return "entity.Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", university=" +university.getId()+
                '}';
    }
}
