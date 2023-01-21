package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Label myLabel;
    private Label myLabel2;
    private TextField nameTextField;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello JavaFX");

        Button button = new Button();
        button.setText("Click Me!");

        myLabel = new Label();
        nameTextField = new TextField();


        myLabel.setText("This is my label");


        nameTextField.setPromptText("Enter Your Name");


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                String name = nameTextField.getText().trim();
                button.setText("Yes! Clicked");

                myLabel.setText(name);

                //System.out.println("Hello JavaFx!");

            }
        });

        FlowPane flowPaneRoot = new FlowPane(10, 10);
        flowPaneRoot.setAlignment(Pos.CENTER);


       // StackPane root = new StackPane();
        flowPaneRoot.getChildren().add(button);
        flowPaneRoot.getChildren().add(myLabel);
        flowPaneRoot.getChildren().add(nameTextField);
        Scene scene =
                new Scene(flowPaneRoot, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

/*
   Object fruitChecked = event.getSource();
        if (bananaCB.equals(fruitChecked)) {
            if (bananaCB.isSelected()) {
             response.setText("Banana Selected");
         }else if(!bananaCB.isSelected()) response.setText("Banana was just cleared");

        }
 */