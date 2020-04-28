/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.domain;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mari
 */
public class PersonTest {

    Person person;

    public PersonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        person = new Person();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
    }

    @Test
    public void idSetAndGetWorks() {
        person.setId(1);
        assertTrue(1 == person.getId());
    }

    @Test
    public void firstnameSetAndGetWorks() {
        person.setFirstName("Etunimi");
        assertEquals("Etunimi", person.getFirstName());
    }

    @Test
    public void lastnameSetAndGetWorks() {
        person.setLastName("nimi");
        assertEquals("nimi", person.getLastName());
    }

    @Test
    public void dobSetAndGetWorks() {
        person.setDateOfBirth(Date.valueOf("2000-01-01"));
        assertEquals(Date.valueOf("2000-01-01"), person.getDateOfBirth());
    }

    @Test
    public void dodSetAndGetWorks() {
        person.setDateOfDeath(Date.valueOf("2000-01-01"));
        assertEquals(Date.valueOf("2000-01-01"), person.getDateOfDeath());
    }

    @Test
    public void pobSetAndGetWorks() {
        person.setPlaceOfBirth("testi");
        assertEquals("testi", person.getPlaceOfBirth());
    }

    @Test
    public void podSetAndGetWorks() {
        person.setPlaceOfDeath("testi");
        assertEquals("testi", person.getPlaceOfDeath());
    }
}
