package ba.unsa.etf.rpr.hadi.dao;
import ba.unsa.etf.rpr.hadi.domain.Professor;
import ba.unsa.etf.rpr.hadi.domain.Student;

import java.util.List;

public interface StudentDao extends Dao<Student> {
    /**
     * Function that allows you to list students that are being taught by same professor
     * @param professor
     * @return list of students
     */
    List<Student> searchByProfessor(Professor professor);
}
