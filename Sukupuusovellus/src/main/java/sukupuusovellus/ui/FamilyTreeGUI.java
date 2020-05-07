/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.ui;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import sukupuusovellus.dao.Dao;
import sukupuusovellus.dao.PersonDao;
import sukupuusovellus.domain.Person;
import sukupuusovellus.logic.FileManagement;

/**
 *
 * @author mari
 */
public class FamilyTreeGUI {

    private FileManagement fileManagement;
//    private PersonDao personDao;
//    private List<Person> persons;

    public FamilyTreeGUI(FileManagement fileManagement) {
        this.fileManagement = fileManagement;
//        this.personDao = new PersonDao(this.fileManagement);
//        this.persons = personDao.list();
    }

    public Parent getScene() {
        VBox layout = new VBox();
        Label coming = new Label("Tässä on sukupuun henkilöt");
        layout.getChildren().add(coming);

        VBox personButtons = new VBox();

        PersonDao personDao = new PersonDao(fileManagement);
        
        List<Person> persons;
        
        

        try {
            persons = personDao.list();
        } catch (Exception e) {
            persons = new ArrayList<>();
            e.printStackTrace();
        }
        
        System.out.println(persons.toString()); // testirivi

        Button[] buttons = new Button[persons.size()];
        
        int i = 0;
        
        for (Person p : persons) {
            buttons[i] = new Button(p.buttonText());
            
            personButtons.getChildren().add(buttons[i]);
            
            i++;
        }

//        int lkm = 1;
//
//        Button[] buttons = new Button[lkm];
//        
//        for (int i = 1; i <= lkm; i++) {
//            Person p = personDao.read(i);
//            buttons[i - 1] = new Button(p.buttonText());
//        }
        
        layout.getChildren().add(personButtons);

        return layout;

    }
}
