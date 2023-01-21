package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXSnackbar;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CellController extends JFXListCell<Task>  {


    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private ImageView iconImageView;

    @FXML
    private Label task;

    @FXML
    private Label dateCreated;

    @FXML
    private Label description;

    @FXML
    private JFXButton deleteButton;

    private FXMLLoader fxmlLoader;

    @FXML
    void initialize() {




    }

    @Override
    public void updateItem(Task myTask, boolean empty) {
        super.updateItem(myTask, empty);

        if (empty || myTask == null) {
            setText(null);
            setGraphic(null);

        }else {
             if (fxmlLoader == null) {
                 fxmlLoader = new FXMLLoader(getClass().getResource("/sample/ListCell.fxml"));
                 fxmlLoader.setController(this);

                 try {
                     fxmlLoader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             //loginSignupButton.getScene().getWindow().hide();

             task.setText(myTask.getTask());
             dateCreated.setText(myTask.getDateCreated());
             description.setText(myTask.getDescription());
             Image newImage = new Image("/sample/assets/new-icon.png");
             iconImageView.setImage(newImage);
             deleteButton.setOnAction(event -> getListView().getItems().remove(getItem()) );
             getListView().setOnMouseClicked(event -> {

                     System.out.println("list clicked");

             });




             setText(null);
             setGraphic(rootAnchorPane);

        }
    }
}
