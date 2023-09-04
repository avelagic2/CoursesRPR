package ba.unsa.etf.rpr.hadi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
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
public class LoginProfController {
    public TextField nameId1;
    public Button okBttn1;
    public TextField codeId1;

    public void okAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/studentList.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Import profesora iz baze");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }
}
