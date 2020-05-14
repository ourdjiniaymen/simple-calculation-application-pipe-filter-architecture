package pipeandfilter.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Trace extends Application {
    public static Text trace = new Text();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Pipe and filter");
        Group root = new Group();
        Scene scene = new Scene(root, 800.0, 600.0, Color.WHITE);

        trace.setLayoutX(80);
        trace.setLayoutY(100);
        trace.setTextAlignment(TextAlignment.LEFT);
        trace.setFont(Font.font("System Bold", FontWeight.NORMAL, 18));
        root.getChildren().add(trace);


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
