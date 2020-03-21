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
    Maksukortti kortti10;
    Maksukortti kortti2;

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
        kortti10 = new Maksukortti(1000);
        kortti2 = new Maksukortti(200);
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
    
    @Test
    public void veloitetaanSummaKortiltaEdullinen() {
        kassa.syoEdullisesti(kortti10);
        assertEquals(760, kortti10.saldo());
    }
    
    @Test
    public void veloitetaanSummaKortiltaMaukkaasti() {
        kassa.syoMaukkaasti(kortti10);
        assertEquals(600, kortti10.saldo());
    }
    
    @Test
    public void korttiVeloitusPalauttaTrueEdullinen() {
        assertTrue(kassa.syoEdullisesti(kortti10));
    }
    
    @Test
    public void korttiVeloitusPalauttaTrueMaukkaasti() {
        assertTrue(kassa.syoMaukkaasti(kortti10));
    }
    
    @Test
    public void korttiVeloitusMyydytEdullisetKasvaa() {
        kassa.syoEdullisesti(kortti10);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiVeloitusMyydytMaukkaatKasvaa() {
        kassa.syoMaukkaasti(kortti10);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void eiVeloitetaSummaaKortiltaEdullinen() {
        kassa.syoEdullisesti(kortti2);
        assertEquals(200, kortti2.saldo());
    }
    
    @Test
    public void eiVeloitetaSummaaKortiltaMaukkaasti() {
        kassa.syoMaukkaasti(kortti2);
        assertEquals(200, kortti2.saldo());
    }
    
    @Test
    public void korttiVeloitusPalauttaFalseEdullinen() {
        assertFalse(kassa.syoEdullisesti(kortti2));
    }
    
    @Test
    public void korttiVeloitusPalauttaFalseMaukas() {
        assertFalse(kassa.syoMaukkaasti(kortti2));
    }
    
    @Test
    public void korttiVeloitusMyydytEdullisetEiKasva() {
        kassa.syoEdullisesti(kortti2);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiVeloitusMyydytMaukkaatEiKasva() {
        kassa.syoMaukkaasti(kortti2);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiVeloitusRahaKassassaEiLisaannyEdullinen() {
        kassa.syoEdullisesti(kortti10);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiVeloitusRahaKassassaEiLisaannyMaukas() {
        kassa.syoMaukkaasti(kortti10);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiVeloitusRahaKassassaEiLisaannyEdullinenEiTarpeeksiArvoa() {
        kassa.syoEdullisesti(kortti2);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiVeloitusRahaKassassaEiLisaannyMaukasEiTarpeeksiArvoa() {
        kassa.syoMaukkaasti(kortti2);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void ladatessaKortinSaldoMuuttuu() {
        kassa.lataaRahaaKortille(kortti2, 1000);
        assertEquals(1200, kortti2.saldo());
    }
    
    @Test
    public void negatiivistaLadattaessaKortinSaldoEiMuutu() {
        kassa.lataaRahaaKortille(kortti2, -1000);
        assertEquals(200, kortti2.saldo());
    }
}
