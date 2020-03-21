/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {

    Kassapaate kassa;

    public KassapaateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kassa = new Kassapaate();
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
    public void kassassaAlussaOikeaMaaraRahaa() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void alussaMyytyjaEdullisiaLounaitaNolla() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void alussaMyytyjaMaukkaitaLounaitaNolla() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahamaaraKasvaaEdullistaMyydessa() {
        kassa.syoEdullisesti(500);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void vaihtorahaOikeinEdullisessa() {
        assertEquals(260, kassa.syoEdullisesti(500));
    }
    
    @Test
    public void oikeaMaaraEdullisiaLounaitaKateisella() {
        kassa.syoEdullisesti(500);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void rahamaaraKasvaaMaukastaMyydessa() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void vaihtorahaOikeinMaukkaassa() {
        assertEquals(100, kassa.syoMaukkaasti(500));
    }
    
    @Test
    public void oikeaMaaraMaukkaitaLounaitaKateisella() {
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahamaaraEiMuutuEdullisessaJosEiRiittavastiRahaa() {
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void rahamaaraEiMuutuMaukkaassaJosEiRiittavastiRahaa() {
        kassa.syoMaukkaasti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kaikkiRahatPalautetaanJosEiRiittävästiRahaaEdulliseen() {
        assertEquals(200, kassa.syoEdullisesti(200));
    }
    
    @Test
    public void kaikkiRahatPalautetaanJosEiRiittävästiRahaaMaukkaaseen() {
        assertEquals(350, kassa.syoMaukkaasti(350));
    }
    
    @Test
    public void myydytEdullisetLounaatEiMuutuJosRahatEiRiita() {
        kassa.syoEdullisesti(200);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myydytMaukkaatLounaatEiMuutuJosRahatEiRiita() {
        kassa.syoEdullisesti(200);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
}
