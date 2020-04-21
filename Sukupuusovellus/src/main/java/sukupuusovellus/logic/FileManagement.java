/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukupuusovellus.logic;

import java.io.File;

/**
 *
 * @author mari
 */
public class FileManagement {
    private File file;
    
    public void openFile(File file) {
        // tähän voisi tehdä tiedostotyypin tarkistuksen
        
        this.file = file;
    }
    
    public String getFileName() {
        if (file == null) {
            return "";
        }
        return this.file.getName();
    }
    
    public String getFilePath() {
        if (file == null) {
            return "";
        }
        return this.file.getPath();
    }
}
