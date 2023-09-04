package ba.unsa.etf.rpr.hadi;
import ba.unsa.etf.rpr.hadi.dao.ProfessorDao;
import ba.unsa.etf.rpr.hadi.dao.ProfessorDaoSQLImpl;
import ba.unsa.etf.rpr.hadi.dao.StudentDao;
import ba.unsa.etf.rpr.hadi.dao.StudentDaoSQLImpl;
import ba.unsa.etf.rpr.hadi.dao.DateBaseDao;
import ba.unsa.etf.rpr.hadi.domain.Professor;
import ba.unsa.etf.rpr.hadi.domain.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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

public class LoginController {
    public Button okBttn;
    public TextField nameId;
    public TextField codeId;
    @FXML
    public ChoiceBox<Professor> choiceB;

    Connection connection;
    private ProfessorDao profadao;
    public LoginController(){

        try{
            this.connection = DateBaseDao.getInstance();

            this.profadao = new ProfessorDaoSQLImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void okAction(ActionEvent actionEvent) throws IOException {

        Student student = new Student();
        student.setName(nameId.getText());
        student.setCode(Integer.parseInt(codeId.getText()));
        student.setProfessor(choiceB.getSelectionModel().getSelectedItem());
        StudentDao dao = new StudentDaoSQLImpl();
        dao.add(student);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/studentList.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Import studenata iz baze");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }


    public void initialize() {
        List<Professor> lista = this.profadao.getAll();
        choiceB.setItems(FXCollections.observableList(lista));
    }
}
