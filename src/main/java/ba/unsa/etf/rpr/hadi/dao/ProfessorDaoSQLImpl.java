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
            this.connection = DateBaseDao.getInstance();
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


    @Override
    public Professor add(Professor item) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO Professors (name, courseId) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getName());
            stmt.setInt(2, item.getCourse().getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next())
            {
                item.setId(rs.getInt(1));
                return item;
            }
            else {
                System.err.println("No generated keys returned after INSERT.");
                throw new SQLException("Failed to retrieve generated keys.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Professor update(Professor item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE Professors SET name=?, courseId=? WHERE id=?");
            stmt.setInt(3,item.getId());
            stmt.setString(1, item.getName());
            stmt.setInt(2, item.getCourse().getId());
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
        List<Professor> professors = new ArrayList<>();
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Professors WHERE courseId = ?");
            stmt.setInt(1, course.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Professor prof = new Professor();
                prof.setId(rs.getInt("id"));
                prof.setName(rs.getString("name"));
                prof.setCourse(course);
                professors.add(prof);
            }
            rs.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return professors;
    }
}
