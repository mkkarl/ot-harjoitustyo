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
import sukupuusovellus.logic.FileManagement;

public class PersonDao implements Dao<Person, Integer> {

    private FileManagement fileManagement;

    public PersonDao(FileManagement fileManagement) {
        this.fileManagement = fileManagement;
    }

    @Override
    public void create(Person person) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileManagement.getFilePath());

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Person"
                + " (firstname, lastname, dob, dod, pob, pod, parent1id, parent2id)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, person.getFirstName());
        stmt.setString(2, person.getLastName());
        stmt.setDate(3, person.getDateOfBirth());
        stmt.setDate(4, person.getDateOfDeath());
        stmt.setString(5, person.getPlaceOfBirth());
        stmt.setString(6, person.getPlaceOfDeath());
        stmt.setInt(7, person.getParent1Id());
        stmt.setInt(8, person.getParent2Id());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

    @Override
    public Person read(Integer key) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileManagement.getFilePath());

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Person WHERE id = ?");
        stmt.setInt(1, key);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        Person person = new Person();

        person.setId(rs.getInt("id"));
        person.setParent1Id(rs.getInt("parent1id"));
        person.setParent2Id(rs.getInt("parent2id"));
        person.setFirstName(rs.getString("firstname"));
        person.setLastName(rs.getString("lastname"));
        person.setDateOfBirth(rs.getDate("dob"));
        person.setDateOfDeath(rs.getDate("dod"));
        person.setPlaceOfBirth(rs.getString("pob"));
        person.setPlaceOfDeath(rs.getString("pod"));

        stmt.close();
        rs.close();
        connection.close();

        return person;

    }

    @Override
    public Person update(Person person) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileManagement.getFilePath());

        PreparedStatement stmt = connection.prepareStatement("UPDATE Person SET firstname = ?, lastname = ?,"
                + "dob = ?, dod = ?, pob = ?, pod = ?, parent1id = ?, parent2id = ? WHERE id = ?");

        stmt.setString(1, person.getFirstName());
        stmt.setString(2, person.getLastName());
        stmt.setDate(3, person.getDateOfBirth());
        stmt.setDate(4, person.getDateOfDeath());
        stmt.setString(5, person.getPlaceOfBirth());
        stmt.setString(6, person.getPlaceOfDeath());
        stmt.setInt(7, person.getParent1Id());
        stmt.setInt(8, person.getParent2Id());
        stmt.setInt(9, person.getId());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();

        return person;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileManagement.getFilePath());

        PreparedStatement stmt = connection.prepareStatement("DELETE FROM Person WHERE id = ?");

        stmt.setInt(1, key);

        stmt.close();
        connection.close();
    }

    @Override
    public List<Person> list() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileManagement.getFilePath());

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Person");
        ResultSet rs = stmt.executeQuery();

        List<Person> persons = new ArrayList<>();

        while (rs.next()) {
            Person person = new Person();

            person.setId(rs.getInt("id"));
            person.setParent1Id(rs.getInt("parent1id"));
            person.setParent2Id(rs.getInt("parent2id"));
            person.setFirstName(rs.getString("firstname"));
            person.setLastName(rs.getString("lastname"));
            person.setDateOfBirth(rs.getDate("dob"));
            person.setDateOfDeath(rs.getDate("dod"));
            person.setPlaceOfBirth(rs.getString("pob"));
            person.setPlaceOfDeath(rs.getString("pod"));

            persons.add(person);
        }

        stmt.close();
        rs.close();
        connection.close();

        return persons;
    }
}
