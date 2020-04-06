/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.dao;

/**
 *
 * @author mari
 */
import sukupuusovellus.domain.Person;
import java.util.*;
import java.sql.*;

public class PersonDao implements Dao<Person, Integer> {

    @Override
    public void create(Person person) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:./tietokanta", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Person"
            + " (firstname, lastname, dob, dod, pob, pod)"
            + " VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, person.getFirstName());
        stmt.setString(2, person.getLastName());
        stmt.setDate(3, person.getDateOfBirth());
        stmt.setDate(4, person.getDateOfDeath());
        stmt.setString(5, person.getPlaceOfBirth());
        stmt.setString(6, person.getPlaceOfDeath());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

    @Override
    public Person read(Integer key) throws SQLException {
        // ei toteutettu
        return null;
    }

    @Override
    public Person update(Person object) throws SQLException {
        // ei toteutettu
        return null;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }

    @Override
    public List<Person> list() throws SQLException {
        // ei toteutettu
        return null;
    }
}
