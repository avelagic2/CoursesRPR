package ba.unsa.etf.rpr.hadi.domain;

import java.util.Objects;

/**
 * Java Bean class for Student
 */
public class Student {
    private int id;
    private String name;
    private int code;
    private Professor professor;

    public Student() {}

    public Student(int id, String name, int code, Professor professor) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.professor = professor;
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
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return name + '/' +code ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id && code == student.code && Objects.equals(name, student.name) &&
                Objects.equals(professor, student.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, professor);
    }
}
