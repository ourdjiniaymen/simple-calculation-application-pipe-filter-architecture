package pipeandfilter.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;

public class Cmpg extends Application {


    private static final CountDownLatch latch = new CountDownLatch(1);
    public static Button somme_btn = new Button();
    public static Button produit_btn = new Button();
    public static Button fact_btn = new Button();
    public static Button out_btn = new Button();
    public static Button trace_btn = new Button();
    public static TextField nombre1 = new TextField();
    public static TextField nombre2 = new TextField();
    public static Text resultat = new Text();



    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Pipe and filter");
        Group root = new Group();
        Scene scene = new Scene(root, 800.0, 600.0, Color.WHITE);


        Text text1 = new Text("LES FORMES ET LES VUES");
        text1.setLayoutX(254.0);
        text1.setLayoutY(53.0);
        text1.setTextAlignment(TextAlignment.CENTER);
        text1.setFont(Font.font("System Bold", FontWeight.BOLD, 24));
        root.getChildren().add(text1);

        Text text2 = new Text("Nombre 1");
        text2.setLayoutX(52.0);
        text2.setLayoutY(137);
        text2.setTextAlignment(TextAlignment.CENTER);
        text2.setFont(Font.font("System Bold", FontWeight.NORMAL, 18));
        root.getChildren().add(text2);


        Text text3 = new Text("Nombre 2");
        text3.setLayoutX(487.0);
        text3.setLayoutY(137);
        text3.setTextAlignment(TextAlignment.CENTER);
        text3.setFont(Font.font("System Bold", FontWeight.NORMAL, 18));
        root.getChildren().add(text3);

        nombre1.setLayoutX(159.0);
        nombre1.setLayoutY(106.0);
        nombre1.setPrefHeight(31.0);
        nombre1.setPrefWidth(150.0);
        nombre1.setFont(Font.font("System Bold", FontWeight.NORMAL, 18));
        root.getChildren().add(nombre1);

        nombre2.setLayoutX(590.0);
        nombre2.setLayoutY(106.0);
        nombre2.setPrefHeight(31.0);
        nombre2.setPrefWidth(150.0);
        nombre2.setFont(Font.font("System Bold", FontWeight.NORMAL, 18));
        root.getChildren().add(nombre2);


        somme_btn = new Button("SOMME");
        somme_btn.setLayoutX(99);
        somme_btn.setLayoutY(240);
        somme_btn.setMaxHeight(31);
        somme_btn.setMinHeight(31);
        somme_btn.setMaxWidth(134);
        somme_btn.setMinWidth(134);
        root.getChildren().add(somme_btn);

        produit_btn = new Button("PRODUIT");
        produit_btn.setLayoutX(330);
        produit_btn.setLayoutY(240);
        produit_btn.setMaxHeight(31);
        produit_btn.setMinHeight(31);
        produit_btn.setMaxWidth(134);
        produit_btn.setMinWidth(134);
        root.getChildren().add(produit_btn);

        fact_btn = new Button("FACTORIEL");
        fact_btn.setLayoutX(598);
        fact_btn.setLayoutY(240);
        fact_btn.setMaxHeight(31);
        fact_btn.setMinHeight(31);
        fact_btn.setMaxWidth(134);
        fact_btn.setMinWidth(134);
        root.getChildren().add(fact_btn);

        resultat = new Text(". . .");
        resultat.setLayoutX(380.0);
        resultat.setLayoutY(404.0);
        resultat.setTextAlignment(TextAlignment.CENTER);
        resultat.setFont(Font.font("System Bold", FontWeight.BOLD, 18));
        root.getChildren().add(resultat);


        out_btn = new Button("QUITTER");
        out_btn.setLayoutX(159.0);
        out_btn.setLayoutY(489.0);
        out_btn.setMaxHeight(31);
        out_btn.setMinHeight(31);
        out_btn.setMaxWidth(134);
        out_btn.setMinWidth(134);
        root.getChildren().add(out_btn);
        out_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });


        trace_btn = new Button("TRACE");
        trace_btn.setLayoutX(479.0);
        trace_btn.setLayoutY(489.0);
        trace_btn.setMaxHeight(31);
        trace_btn.setMinHeight(31);
        trace_btn.setMaxWidth(134);
        trace_btn.setMinWidth(134);
        root.getChildren().add(trace_btn);


        primaryStage.setScene(scene);
        primaryStage.show();
        latch.countDown();

    }

    public static void showError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void waitForInterface() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void showTrace(){
       Trace trace = new Trace();
        try {
            trace.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
