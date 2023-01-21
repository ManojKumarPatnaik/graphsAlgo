package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.LoginController;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/FXML/sample.fxml"));
        Parent root = loader.load();

        loader.getController();

        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);

    }
}
