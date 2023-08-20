package ba.unsa.etf.rpr.hadi.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Basic Java Class for History
 */
public class History {

    private int id;
    private Student student;
    private Professor professor;
    private String thesis;
    private Date date;

    public History() {}

    public History(int id, Student student, Professor professor, String thesis, Date date) {
        this.id = id;
        this.student = student;
        this.professor = professor;
        this.thesis = thesis;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", student=" + student +
                ", professor=" + professor +
                ", thesis='" + thesis + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        History history = (History) o;
        return id == history.id && student.equals(history.student) &&
                professor.equals(history.professor) &&
                thesis.equals(history.thesis) && date.equals(history.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, professor, thesis, date);
    }
}
