package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("kakuroView.fxml"));

        AnchorPane anchorPane = new AnchorPane(root);

        controller.Controller controller = new controller.Controller();
        GridPane gridPane = controller.getGridPane();
        anchorPane.getChildren().add(gridPane);
        Scene scene = new Scene(anchorPane, controller.sceneWidth, controller.sceneHeight);
        primaryStage.setTitle("Level " + controller.level.toUpperCase() + " | Map " + controller.mapNo);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
