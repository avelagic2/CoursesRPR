package ba.unsa.etf.rpr.hadi.dao;
import ba.unsa.etf.rpr.hadi.domain.History;
import ba.unsa.etf.rpr.hadi.domain.Professor;
import ba.unsa.etf.rpr.hadi.domain.Student;

import java.util.List;

public interface HistoryDao extends Dao<History> {
    /**
     * Function that allows you to list history of the professor
     * @param professor searched professor
     * @return history list
     */
    List<History> searchByProfessor(Professor professor);

    /**
     * Function that allows you to list history of a student
     * @param student searched student
     * @return history list
     */
    List<History> searchByStudent(Student student);
}
