package ba.unsa.etf.rpr.hadi;

import ba.unsa.etf.rpr.hadi.dao.*;
import ba.unsa.etf.rpr.hadi.domain.Course;
import ba.unsa.etf.rpr.hadi.domain.Student;
import ba.unsa.etf.rpr.hadi.domain.Professor;
//import javafx.application.Application;

import java.util.List;

/**
 * Basic Main class where testing of classes and methods are done
 */
public class Main {
    public static void main(String[] args) {
        /*
        ProfessorDaoSQLImpl dao = new ProfessorDaoSQLImpl();
        Professor prof = new Professor();
        prof.setId(4);
        prof.setName("Miki Mikic");
        prof.setCourse(new Course(2, "Databases"));
        dao.add(prof);
        System.out.println(dao.getAll());
        */
        /*
        // test ispisa
        CourseDao dao = new CourseDaoSQLImpl();
        Course course = dao.getById(1);
        System.out.println(course);
        */
        //Professor profi = new Professor(19,"Haha Hahic",new Course(1, "Programming"));
        //profi.setId(12);
        ProfessorDao dao = new ProfessorDaoSQLImpl();
        //profi = dao.update(profi);
        System.out.println(dao.searchByCourse(new Course(1, "Programming")));





    }
}