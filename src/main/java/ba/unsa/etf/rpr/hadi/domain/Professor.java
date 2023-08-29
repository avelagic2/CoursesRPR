package ba.unsa.etf.rpr.hadi.domain;

import java.util.Objects;

/**
 * Java Bean class for Professor
 */
public class Professor {
    private int id;
    private String name;
    private Course course;

    public Professor() {}

    public Professor(int id, String name, Course course) {
        this.id = id;
        this.name = name;
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
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Professor professor = (Professor) obj;
        return id == professor.id && name.equals(professor.name) &&
                course.equals(professor.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, course);
    }

}

