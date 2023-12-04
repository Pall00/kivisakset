package kivipaperisakset;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class PeliTest {

    private Peli peli;

    @Before    public void setup() {
        peli = new Peli();
    }

      @Test
    public void testaaTasapeliKunValinnatOvatSamat() {
        Peli peli = new Peli();
        assertEquals("tasapeli", peli.tarkistaVoittaja("kivi", "kivi"));
        assertEquals("tasapeli", peli.tarkistaVoittaja("paperi", "paperi"));
        assertEquals("tasapeli", peli.tarkistaVoittaja("sakset", "sakset"));
    }

    @Test
    public void testaaPelaaja1Voittaa() {
        Peli peli = new Peli();
        assertEquals("p1", peli.tarkistaVoittaja("kivi", "sakset"));
        assertEquals("p1", peli.tarkistaVoittaja("paperi", "kivi"));
        assertEquals("p1", peli.tarkistaVoittaja("sakset", "paperi"));
    }

    @Test
    public void testaaPelaaja2Voittaa() {
        Peli peli = new Peli();
        assertEquals("p2", peli.tarkistaVoittaja("sakset", "kivi"));
        assertEquals("p2", peli.tarkistaVoittaja("kivi", "paperi"));
        assertEquals("p2", peli.tarkistaVoittaja("paperi", "sakset"));
    }

   

    @Test
    public void pelaaKierrosPaivittaaTilastotOikein() {
        peli.pelaaKierros();
        assertEquals(1, peli.pelatutPelit);
    }

   
}