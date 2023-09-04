package ba.unsa.etf.rpr.hadi;
import ba.unsa.etf.rpr.hadi.dao.ProfessorDao;
import ba.unsa.etf.rpr.hadi.dao.ProfessorDaoSQLImpl;
import ba.unsa.etf.rpr.hadi.dao.StudentDao;
import ba.unsa.etf.rpr.hadi.dao.StudentDaoSQLImpl;
import ba.unsa.etf.rpr.hadi.dao.DateBaseDao;
import ba.unsa.etf.rpr.hadi.domain.Professor;
import ba.unsa.etf.rpr.hadi.domain.Student;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller implements Initializable {
    public Button okB1;
    public Button okB2;
    Connection connection;
    private StudentDao studentdao;
    private ProfessorDao profadao;
    public Controller(){

        try{
            this.connection = DateBaseDao.getInstance();
            this.studentdao = new StudentDaoSQLImpl();
            this.profadao = new ProfessorDaoSQLImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    ListView<Student> studentListView;
    @FXML
    ListView<Professor> professorListView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Student> lista = this.studentdao.getAll();
        studentListView.setItems(FXCollections.observableList(lista));

        List<Professor> lista2 = this.profadao.getAll();
        professorListView.setItems(FXCollections.observableList(lista2));




    }

    public void okA1(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("login studenta");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }

    public void okA2(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/login1.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("login profija");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }
}
