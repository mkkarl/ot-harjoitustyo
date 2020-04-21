/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.domain;

//import java.util.Date;
import java.sql.Date;

/**
 *
 * @author mari
 */
public class Person {

    private int id;
    private String firstname;
    private String lastname;
    private Date dob;
    private Date dod;
    private String pob;
    private String pod;

    public Person() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setDateOfBirth(Date dob) {
        this.dob = dob;
    }

    public Date getDateOfBirth() {
        return dob;
    }

    public void setDateOfDeath(Date dod) {
        this.dod = dod;
    }

    public Date getDateOfDeath() {
        return dod;
    }

    public void setPlaceOfBirth(String pob) {
        this.pob = pob;
    }

    public String getPlaceOfBirth() {
        return pob;
    }

    public void setPlaceOfDeath(String pod) {
        this.pod = pod;
    }

    public String getPlaceOfDeath() {
        return pod;
    }

}
