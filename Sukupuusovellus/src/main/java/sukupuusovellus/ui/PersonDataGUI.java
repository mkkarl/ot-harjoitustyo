/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.ui;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import sukupuusovellus.dao.PersonDao;
import sukupuusovellus.domain.Person;
import sukupuusovellus.logic.FileManagement;

/**
 *
 * @author mari
 */
public class PersonDataGUI {

    private FileManagement fileManagement;

    public PersonDataGUI(FileManagement fileManagement) {
        this.fileManagement = fileManagement;
    }

    public Parent getScene(BorderPane layoutGUI, Person person) {
        FamilyTreeGUI ftgui = new FamilyTreeGUI(fileManagement);

        PersonDao dao = new PersonDao(fileManagement);

        VBox fields = new VBox();

        Label fNameL = new Label("Etunimi");
        TextField fNameTF = new TextField(person.getFirstName());
        Label lNameL = new Label("Sukunimi");
        TextField lNameTF = new TextField(person.getLastName());
        Label dobL = new Label("Syntymäaika");
        DatePicker dobDP = new DatePicker();
        if (person.getDateOfBirth() != null) {
            dobDP.setValue(person.getDateOfBirth().toLocalDate());
        }
        Label pobL = new Label("Syntymäpaikka");
        TextField pobTF = new TextField(person.getPlaceOfBirth());
        Label dodL = new Label("Kuolinaika");
        DatePicker dodDP = new DatePicker();
        if (person.getDateOfDeath() != null) {
            dodDP.setValue(person.getDateOfDeath().toLocalDate());
        }
        Label podL = new Label("Kuolinpaikka");
        TextField podTF = new TextField(person.getPlaceOfDeath());

        Button saveButton = new Button("Tallenna");

        saveButton.setOnAction((event) -> {
            person.setFirstName(fNameTF.getText());
            person.setLastName(lNameTF.getText());
            if (dobDP.getValue() != null) {
                person.setDateOfBirth(Date.valueOf(dobDP.getValue()));
            }
            person.setPlaceOfBirth(pobTF.getText());
            if (dodDP.getValue() != null) {
                person.setDateOfDeath(Date.valueOf(dodDP.getValue()));
            }
            person.setPlaceOfDeath(podTF.getText());

            if (person.getId() == 0) {
                try {
                    dao.create(person);
                } catch (SQLException ex) {
                    Logger.getLogger(PersonDataGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    dao.update(person);
                } catch (SQLException ex) {
                    Logger.getLogger(PersonDataGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Button returnButton = new Button("Palaa puuhun");

        returnButton.setOnAction((event) -> {
            layoutGUI.setCenter(ftgui.getScene(layoutGUI));
        });

        fields.getChildren().addAll(fNameL, fNameTF, lNameL, lNameTF, dobL, dobDP, pobL, pobTF, dodL, dodDP, podL, podTF, saveButton, returnButton);

        return fields;

    }

}
