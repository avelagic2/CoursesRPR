package ba.unsa.etf.rpr.hadi.dao;

import ba.unsa.etf.rpr.hadi.domain.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoSQLImpl implements CourseDao{

    private Connection connection;

    public CourseDaoSQLImpl(){
        try{
            this.connection = DateBaseDao.getInstance();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public Course getById(int id) {
        String query = "SELECT * FROM Courses WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                rs.close();
                return course;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Course add(Course item) {
        String insert = "INSERT INTO Courses(name) VALUES(?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getName());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            item.setId(rs.getInt(1));
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Course update(Course item) {
        String insert = "UPDATE Courses SET name = ? where id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, item.getName());
            stmt.setObject(2, item.getId());
            stmt.executeUpdate();
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String insert = "DELETE FROM Courses WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getAll() {
        String query = "SELECT * FROM Courses";
        List<Course> courses = new ArrayList<Course>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                courses.add(course);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return courses;
    }
}