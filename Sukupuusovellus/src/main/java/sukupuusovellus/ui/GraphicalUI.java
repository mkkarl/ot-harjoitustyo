/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.ui;

import java.io.File;
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
import sukupuusovellus.Sukupuusovellus;
import sukupuusovellus.logic.FileManagement;

/**
 *
 * @author mari
 */
public class GraphicalUI extends Application {
    
    private FileManagement fileManagement;
    
    @Override
    public void start(Stage stage) throws Exception {
        FileChooser fileChooser = new FileChooser();
        
        this.fileManagement = new FileManagement();

        NewFamilyTreeGUI nftgui = new NewFamilyTreeGUI();
        OpenFamilyTreeGUI oftgui = new OpenFamilyTreeGUI();
        
        BorderPane layout = new BorderPane();
        
        Label header = new Label("Sukupuu");
        header.setPadding(new Insets(20, 20, 20, 20));
        
        Label footer = new Label(fileManagement.getFileName());
        footer.setPadding(new Insets(20, 20, 20, 20));
        
        VBox buttons = new VBox();
        
        Button newTree = new Button("Istuta uusi sukupuu");
        Button openTree = new Button("Avaa sukupuu");
        
        buttons.getChildren().add(newTree);
        buttons.getChildren().add(openTree);
        
        layout.setTop(header);
        layout.setCenter(buttons);
        layout.setBottom(footer);
        
        newTree.setOnAction((event) -> layout.setCenter(nftgui.getScene()));
//        openTree.setOnAction((event) -> layout.setCenter(oftgui.getScene()));

        openTree.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File file = fileChooser.showOpenDialog(stage);
//                    FileManagement fileManagement = new FileManagement();
                    fileManagement.openFile(file);
                }
            });

        Scene scene = new Scene(layout, 400, 300);
        
        stage.setScene(scene);
        stage.show();
        
    }
}
