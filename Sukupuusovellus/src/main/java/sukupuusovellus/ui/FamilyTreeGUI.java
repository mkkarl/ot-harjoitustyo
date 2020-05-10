/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.ui;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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

    public Parent getScene(BorderPane layoutGUI) {
        PersonDataGUI pdgui = new PersonDataGUI(fileManagement);

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

        Button[] buttons = new Button[persons.size()];

        int i = 0;

        for (Person p : persons) {
            buttons[i] = new Button(p.buttonText());

            buttons[i].setOnAction((event) -> {
                layoutGUI.setCenter(pdgui.getScene(layoutGUI, p));
            });

            personButtons.getChildren().add(buttons[i]);

            i++;
        }

        Button newPerson = new Button("Luo uusi henkilö");

        newPerson.setOnAction((event) -> {
            layoutGUI.setCenter(pdgui.getScene(layoutGUI, new Person()));
        });

        layout.getChildren().add(personButtons);
        layout.getChildren().add(newPerson);

        return layout;

    }
}
