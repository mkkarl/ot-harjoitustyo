/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.logic;

import java.io.File;
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
public class LogicTest {
    FileManagement fm;
    DatabaseManagement dbm;
    
    public LogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.fm = new FileManagement();
        this.dbm = new DatabaseManagement(fm);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    public void openFileWorks() {
        File f = new File("./testitietokannat/testitietokanta1.db");
        
        fm.openFile(f);
        
        assertNotNull(fm.getFileName());
    }
    
    public void createNewDBWorks() {
        File f = new File("./testitietokannat/testitietokanta.db");
        
        fm.openFile(f);
        
        dbm.createNewDatabase();
    }
}
