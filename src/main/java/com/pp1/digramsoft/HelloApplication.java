package com.pp1.digramsoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public final Group root = new Group();
    public final VBox stakeholdersRoot = new VBox();
    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    private static final int LEFT_WINDOW_WIDTH = 260;
    private static final int LEFT_WINDOW_HEIGHT = 720;

    private final ArrayList<Stakeholder> stakeholders = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        // Window Background
        Rectangle leftWindow = new Rectangle(0, 0, LEFT_WINDOW_WIDTH, LEFT_WINDOW_HEIGHT);
        leftWindow.setFill(Color.GRAY);
        root.getChildren().add(leftWindow);
        // -> Stakeholder list
        ScrollPane stakeholderList = new ScrollPane(stakeholdersRoot);
        stakeholderList.pannableProperty().set(true);
        stakeholderList.setLayoutX(10);
        stakeholderList.setLayoutY(10);
        stakeholderList.setPrefSize(LEFT_WINDOW_WIDTH - 20, LEFT_WINDOW_HEIGHT - 330);
        stakeholderList.setMaxHeight(LEFT_WINDOW_HEIGHT - 330);
        stakeholderList.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);


        root.getChildren().add(stakeholdersRoot);
        // Stakeholder Generator
        Generator stakeholderGenerator = new Generator(10, 600, "Generate", EntityType.STAKEHOLDER, stakeholders, stakeholdersRoot);
        root.getChildren().add(stakeholderGenerator);
        // -> Diagram list

        stage.setScene(scene);
        stage.show();
    }
}
