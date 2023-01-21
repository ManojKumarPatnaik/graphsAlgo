package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //MVC - Model - View - Controller

    @FXML
    private Button clickMeButton;

    @FXML
    private Label labelId;

    @FXML
    private JFXTextField textField;

    @FXML
    private JFXButton materialButton;




    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        materialButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textString = textField.getText().trim();

                labelId.setText(textString);

            }
        });

    }
}
