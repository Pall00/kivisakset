package kivipaperisakset;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;


public class PelaajaTest {

    private Pelaaja pelaaja;

    @Before
    public void setup() {
        pelaaja = new Pelaaja();
    }

    @Test
    public void testIncrementVoitot() {
        pelaaja.incrementVoitot();
        assertEquals(1, pelaaja.getVoitot());
    }
}


