package ba.unsa.etf.rpr.hadi;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DualListViewExample extends Application {
    @Override
    public void start(Stage primaryStage) {

        ListView<String> professorsListView = new ListView<>();
        ObservableList<String> professorsItems = FXCollections.observableArrayList();
        populateListViewFromDatabase(professorsItems, "Professors");
        professorsListView.setItems(professorsItems);


        ListView<String> studentsListView = new ListView<>();
        ObservableList<String> studentsItems = FXCollections.observableArrayList();
        populateListViewFromDatabase(studentsItems, "Students");
        studentsListView.setItems(studentsItems);


        HBox root = new HBox(20);
        root.getChildren().addAll(professorsListView, studentsListView);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("ListView");
        primaryStage.show();
    }

    private void populateListViewFromDatabase(ObservableList<String> items, String tableName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_ams2022", "freedb_ams2022", "HxH7WgYQPs@6p*s");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT name FROM" + tableName );

            while (resultSet.next()) {
                String itemName = resultSet.getString("name");
                items.add(itemName);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
