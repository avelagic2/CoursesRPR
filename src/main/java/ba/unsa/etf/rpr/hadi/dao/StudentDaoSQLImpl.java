package ba.unsa.etf.rpr.hadi.dao;

import ba.unsa.etf.rpr.hadi.domain.Professor;
import ba.unsa.etf.rpr.hadi.domain.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDaoSQLImpl implements StudentDao {
    private Connection connection;

    public StudentDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("","","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Student getById(int id) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Students WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getNString("name"));
                student.setCode(rs.getInt("code"));
                student.setProfessor(new ProfessorDaoSQLImpl().getById(rs.getInt("professorId")));
                rs.close();
                return student;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int getMaxId(){
        int id=1;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT MAX(id)+1 FROM Students");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                rs.close();
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    @Override
    public Student add(Student item) {
        int id = getMaxId();
        try{
            PreparedStatement stmt =  this.connection.prepareStatement("INSERT INTO Students VALUES (id, item.getName(), item.getCode(), item.getProfessor().getId())");
            stmt.executeUpdate();
            item.setId(id);
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student update(Student item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE Students SET name=?, code=?, professorId=? WHERE id=?");
            stmt.setInt(4,item.getId());
            stmt.setString(1, item.getName());
            stmt.setInt(2, (int)item.getCode());
            stmt.setInt(3, item.getProfessor().getId());
            stmt.executeUpdate();
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("DELETE from Students WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<Student>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * from Students");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setProfessor(new ProfessorDaoSQLImpl().getById(rs.getInt("professorId")));
                students.add(student);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> searchByProfessor(Professor prof) {
        List<Student> students = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Students WHERE professorId = ?");
            stmt.setInt(1, prof.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setCode(rs.getInt("code"));
                student.setProfessor(prof);
                students.add(student);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
