package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements EventHandler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton signUp;

    @FXML
    private JFXButton login;

    @FXML
    private JFXCheckBox rememberMe;

    @FXML
    private JFXButton forgotPwd;

    @FXML
    void initialize() {
        userName.setStyle("-fx-text-inner-color: #a0a2ab;");
        password.setStyle("-fx-text-inner-color: #a0a2ab;");
        signUp.setOnAction(this);
        login.setOnAction(this);

//        signUp.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                setLogin();
//            }
//        });




    }


    @Override
    public void handle(Event event) {
        if (event.getTarget().equals(signUp)) {

            showSignUpWindow();

        }else if (event.getTarget().equals(login)) {
            PauseTransition pauseTransition = new PauseTransition();
            pauseTransition.setDuration(Duration.seconds(3));
            pauseTransition.setOnFinished(event1 -> {
                System.out.println("Transition finished!");
                System.out.println("Login!");
            });
            pauseTransition.play();

        }
    }
    void showSignUpWindow() {
        login.getScene().getWindow().hide();

        try {
            Stage signup = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("/sample/FXML/SignUp.fxml"));
            Scene scene = new Scene(root);
            signup.setScene(scene);
            signup.show();
            signup.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
