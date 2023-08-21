package ba.unsa.etf.rpr.hadi.dao;

import ba.unsa.etf.rpr.hadi.domain.History;
import ba.unsa.etf.rpr.hadi.domain.Professor;
import ba.unsa.etf.rpr.hadi.domain.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDaoSQLImpl implements HistoryDao {
    private Connection connection;

    public HistoryDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("","","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public History getById(int id) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Histories WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setStudent(new StudentDaoSQLImpl().getById(rs.getInt("studentId")));
                history.setProfessor(new ProfessorDaoSQLImpl().getById(rs.getInt("professorId")));
                history.setThesis(rs.getString("thesis"));
                rs.close();
                return history;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public History add(History item) {

        return null;
    }

    @Override
    public History update(History item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE Histories SET studentId=?, professorId=?, thesis=? WHERE id=?");
            stmt.setInt(4,item.getId());
            stmt.setInt(1, item.getStudent().getId());
            stmt.setInt(2, item.getProfessor().getId());
            stmt.setString(3, item.getThesis());
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
            PreparedStatement stmt = this.connection.prepareStatement("DELETE from Histories WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<History> getAll() {
        List<History> histories = new ArrayList<History>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Histories");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setStudent(new StudentDaoSQLImpl().getById(rs.getInt("studentId")));
                history.setProfessor(new ProfessorDaoSQLImpl().getById(rs.getInt("professorId")));
                history.setThesis(rs.getString("thesis"));
                histories.add(history);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }

    @Override
    public List<History> searchByStudent(Student student) {
        List<History> histories = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Histories WHERE studentId = ?");
            stmt.setInt(1, student.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                History history = new History();
                history.setStudent(student);
                history.setId(rs.getInt("id"));
                history.setProfessor(new ProfessorDaoSQLImpl().getById(rs.getInt("professorId")));
                history.setThesis(rs.getString("thesis"));
                histories.add(history);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }

    @Override
    public List<History> searchByProfessor(Professor professor) {
        List<History> histories = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Histories WHERE professorId = ?");
            stmt.setInt(1, professor.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                History history = new History();
                history.setProfessor(professor);
                history.setId(rs.getInt("id"));
                history.setStudent(new StudentDaoSQLImpl().getById(rs.getInt("studentId")));
                history.setThesis(rs.getString("thesis"));
                histories.add(history);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }
}
