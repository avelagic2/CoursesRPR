package ba.unsa.etf.rpr.hadi;

import ba.unsa.etf.rpr.hadi.dao.*;
import ba.unsa.etf.rpr.hadi.domain.Course;
import ba.unsa.etf.rpr.hadi.domain.Student;
import ba.unsa.etf.rpr.hadi.domain.Professor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //CourseDaoSQLImpl courseDaoSQL = new CourseDaoSQLImpl();
        //ProfessorDaoSQLImpl professorDaoSQL = new ProfessorDaoSQLImpl();
        //StudentDaoSQLImpl studentDaoSQL = new StudentDaoSQLImpl();
        /*
        //ispisivanje svih kurseva
        CourseDao dao = new CourseDaoSQLImpl();
        List<Course> courses = dao.getAll();
        System.out.println(courses);
        //ispisivanje svih profesora
        ProfessorDao dao1 = new ProfessorDaoSQLImpl();
        List<Professor> professor = dao1.getAll();
        System.out.println(professor);
         */
        /*
        Professor professor = new Professor();
        professor.setName("Mirzet Mirzic");
        Course curse = new Course();
        curse.setId(3);
        professor.setCourse(curse);
        ProfessorDao profaDao = new ProfessorDaoSQLImpl();
        profaDao.add(professor);
        System.out.println(profaDao.getAll());

        Student student = new Student();
        student.setName("Fehim");
        student.setCode(18576);
        Professor profi = new Professor();
        profi.setId(4);
        student.setProfessor(profi);
        StudentDao studiDao = new StudentDaoSQLImpl();
        studiDao.add(student);
        System.out.println(studiDao.getAll());
        /*CourseDao cursDao = new CourseDaoSQLImpl();
        cursDao.add(new Course(4, "Electronics"));
        System.out.println(cursDao.getAll());*/
        /*ProfessorDaoSQLImpl dao = new ProfessorDaoSQLImpl();
        Professor prof = new Professor();
        prof.setId(4);
        prof.setName("Kerim Muhovic");
        prof.setCourse(new Course(2, "Databases"));
        dao.add(prof);*/


    }
}