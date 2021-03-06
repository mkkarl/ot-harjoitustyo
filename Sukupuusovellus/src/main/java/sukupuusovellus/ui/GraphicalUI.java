/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.ui;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sukupuusovellus.logic.DatabaseManagement;
import sukupuusovellus.logic.FileManagement;

/**
 *
 * @author mari
 */
public class GraphicalUI extends Application {

    private FileManagement fileManagement;

    @Override
    public void init() {
        this.fileManagement = new FileManagement();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FileChooser fileChooser = new FileChooser();

        BorderPane layout = new BorderPane();

        FamilyTreeGUI ftgui = new FamilyTreeGUI(fileManagement);

        Label header = new Label("Sukupuu");
        header.setPadding(new Insets(20, 20, 20, 20));

        Label footer = new Label(fileManagement.getFileName());
        footer.setPadding(new Insets(20, 20, 20, 20));

        VBox buttons = new VBox();

        Button newTree = new Button("Istuta uusi sukupuu");
        Button openTree = new Button("Avaa sukupuu");
        Button searchTree = new Button("Tutki puuta");

        buttons.getChildren().add(newTree);
        buttons.getChildren().add(openTree);
        buttons.getChildren().add(searchTree);

        layout.setTop(header);
        layout.setCenter(buttons);
        layout.setBottom(footer);

        // tiedostojen käsittelyyn voisi lisätä rajauksia tiedostomuotoihin
        // entä jos tiedostonimi on jo käytössä?
        newTree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                File file = fileChooser.showSaveDialog(stage);

                if (file != null) {
                    try {

                        file.createNewFile();

                        fileManagement.openFile(file);

                        DatabaseManagement dm = new DatabaseManagement(fileManagement);
                        dm.createNewDatabase();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                footer.setText(fileManagement.getFileName());
            }
        });

        openTree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                File file = fileChooser.showOpenDialog(stage);
                fileManagement.openFile(file);

                footer.setText(fileManagement.getFileName());
            }
        });

        searchTree.setOnAction((event) -> layout.setCenter(ftgui.getScene(layout)));

        Scene scene = new Scene(layout, 800, 600);

        stage.setScene(scene);
        stage.show();

    }
}
