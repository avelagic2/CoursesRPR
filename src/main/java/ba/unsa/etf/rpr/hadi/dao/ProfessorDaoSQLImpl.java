package ba.unsa.etf.rpr.hadi.dao;
import ba.unsa.etf.rpr.hadi.domain.Course;
import ba.unsa.etf.rpr.hadi.domain.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDaoSQLImpl implements ProfessorDao{

    private Connection connection;

    public ProfessorDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("","","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Professor getById(int id) {
        String query = "SELECT * FROM Professors WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setName(rs.getNString("name"));
                professor.setCourse(new CourseDaoSQLImpl().getById(rs.getInt("courseId")));
                rs.close();
                return professor;
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
            PreparedStatement statement = this.connection.prepareStatement("SELECT MAX(id)+1 FROM Professors");
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
    public Professor add(Professor item) {
        int id = getMaxId();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO Professor VALUES (id, item.getName(), item.getCourse().getId)");
            stmt.executeUpdate();
            item.setId(id);
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Professor update(Professor item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE Professors SET name=?, courseId=? WHERE id=?");
            stmt.setInt(1,item.getId());
            stmt.setString(2, item.getName());
            stmt.setInt(3, item.getCourse().getId());
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
            PreparedStatement stmt = this.connection.prepareStatement("DELETE from Professors WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Professor> getAll() {
        List<Professor> lists = new ArrayList<Professor>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * from Professors");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setName(rs.getString("name"));
                professor.setCourse(new CourseDaoSQLImpl().getById(rs.getInt("courseId")));
                lists.add(professor);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public List<Professor> searchByCourse(Course course) {
        List<Professor> lists = new ArrayList<>();
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Professors WHERE courseId = ?");
            stmt.setInt(1, course.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Professor prof = new Professor();
                prof.setId(rs.getInt("id"));
                prof.setName(rs.getString("name"));
                prof.setCourse(course);
                lists.add(prof);
            }
            rs.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return lists;
    }
}
