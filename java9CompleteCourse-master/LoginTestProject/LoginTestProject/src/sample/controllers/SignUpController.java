package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField signUpUsername;

    @FXML
    private JFXTextField signUpPassword;

    @FXML
    private JFXRadioButton signUpMale;

    @FXML
    private ToggleGroup gender;

    @FXML
    private JFXRadioButton signUpFemale;

    @FXML
    private JFXTextField signUpLocation;
    @FXML
    private JFXButton signUpSignUp;

    @FXML
    void initialize() {
        signUpUsername.setStyle("-fx-text-inner-color: #a0a2ab;");
        signUpPassword.setStyle("-fx-text-inner-color: #a0a2ab;");
        signUpLocation.setStyle("-fx-text-inner-color: #a0a2ab;");


    }


}
