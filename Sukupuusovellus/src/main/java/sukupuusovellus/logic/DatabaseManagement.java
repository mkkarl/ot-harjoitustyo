/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mari
 */
public class DatabaseManagement {

    private FileManagement fileManagement;

    public DatabaseManagement(FileManagement fileManagement) {
        this.fileManagement = fileManagement;
    }

    public void createNewDatabase() {
        try ( Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileManagement.getFilePath(), "sa", "")) {

            connection.prepareStatement("CREATE TABLE Person ("
                    + "id INTEGER PRIMARY KEY,"
                    + "firstname VARCHAR(200),"
                    + "lastname VARCHAR(200),"
                    + "dob DATE,"
                    + "dod DATE,"
                    + "pob VARCHAR(50),"
                    + "pod VARCHAR(50)"
                    + ");").executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
