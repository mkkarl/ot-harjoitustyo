/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mari
 */
public class GraphicalUI extends Application {
    
    @Override
    public void start(Stage window) throws Exception {
//        System.out.println("Hello world!");

        NewFamilyTreeGUI nftgui = new NewFamilyTreeGUI();
        OpenFamilyTreeGUI oftgui = new OpenFamilyTreeGUI();
        
        BorderPane layout = new BorderPane();
        
        Label header = new Label("Sukupuu");
        header.setPadding(new Insets(20, 20, 20, 20));
        
        VBox buttons = new VBox();
        
        Button newTree = new Button("Uusi sukupuu");
        Button openTree = new Button("Avaa sukupuu");
        
        buttons.getChildren().add(newTree);
        buttons.getChildren().add(openTree);
        
        layout.setTop(header);
        layout.setCenter(buttons);
        
        newTree.setOnAction((event) -> layout.setCenter(nftgui.getScene()));
        openTree.setOnAction((event) -> layout.setCenter(oftgui.getScene()));
        
        Scene scene = new Scene(layout, 400, 300);
        
        window.setScene(scene);
        window.show();
        
    }
}
