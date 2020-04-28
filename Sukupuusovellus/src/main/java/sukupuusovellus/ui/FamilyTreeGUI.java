/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.ui;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
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
        Label coming = new Label("Toiminto tulossa...");
        layout.getChildren().add(coming);

        PersonDao personDao = new PersonDao(fileManagement);
        
        List<Person> persons;

        try {
            persons = personDao.list();
        } catch (Exception e) {
            persons = new ArrayList<>();
        }

        ObservableList<Person> obPersons = FXCollections.observableArrayList(persons);

        TableView<Person> tv = new TableView<>(obPersons);
        
        TableColumn<Person, String> firstNameCol = new TableColumn<>("Etunimi");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>(persons.get(0).getFirstName()));
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Sukunimi");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>(persons.get(0).getLastName()));
//        TableColumn<Person, Date> dobCol = new TableColumn<>("Syntymäaika");
//        dobCol.setCellValueFactory(new PropertyValueFactory<>(persons.get(0).getDateOfBirth()));
        
        tv.getColumns().setAll(firstNameCol, lastNameCol);
        
        layout.getChildren().add(tv);

        return layout;

    }
}
