package ba.unsa.etf.rpr.hadi.dao;
import ba.unsa.etf.rpr.hadi.domain.Course;
import ba.unsa.etf.rpr.hadi.domain.Professor;

import java.util.List;

public interface ProfessorDao extends Dao<Professor> {
    /**
     * Function that allows you to search professors by course id
     * @param course name
     * @return List of professors that teach some course
     */
    List<Professor> searchByCourse(Course course);
}
