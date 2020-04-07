/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.ui;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author mari
 */
public class NewFamilyTreeGUI {
    
    public Parent getScene() {
        
        VBox layout = new VBox();
        
        Label coming = new Label("Uuden sukupuun istutus tulossa...");
        
        layout.getChildren().add(coming);
        
        return layout;
    }
    
}
