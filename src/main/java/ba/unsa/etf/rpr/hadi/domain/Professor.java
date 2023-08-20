package ba.unsa.etf.rpr.hadi.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Basic Java Class for Professor
 */
public class Professor {
    private int id;
    private String name;
    private Date workBeginning;
    private Course course;

    public Professor() {}

    public Professor(int id, String name, Date workBeginning, Course course) {
        this.id = id;
        this.name = name;
        this.workBeginning = workBeginning;
        this.course = course;
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

    public Date getWorkBeginning() {
        return workBeginning;
    }

    public void setWorkBeginning(Date workBeginning) {
        this.workBeginning = workBeginning;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", WorkBeginning=" + workBeginning +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Professor professor = (Professor) obj;
        return id == professor.id && name.equals(professor.name) &&
                Objects.equals(workBeginning, professor.workBeginning) &&
                course.equals(professor.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, workBeginning, course);
    }

}

