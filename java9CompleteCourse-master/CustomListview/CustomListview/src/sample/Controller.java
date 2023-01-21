package sample;

import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.net.URL;

public class Controller {


    @FXML
    private JFXListView<Task> listView;

    private ObservableList<Task> tasks;

    @FXML
    void initialize() {
        tasks = FXCollections.observableArrayList();


        tasks.addAll(
                new Task("Wash Car", "11-11-97", "description"),
                new Task("Clean house", "11-11-95", "I will be washiing this car today and tomorrow"),
                new Task("Clean house", "11-11-95", "stuff"),
                new Task("Clean house", "11-11-95", "stuff"),
                new Task("Clean house", "11-11-95", "stuff"),
                new Task("Clean house", "11-11-95", "stuff"),
                new Task("Clean house", "11-11-95", "stuff")
        );



        listView.setItems(tasks);
        listView.setCellFactory(CellController -> new CellController());




    }
}
