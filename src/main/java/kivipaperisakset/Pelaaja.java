
package kivipaperisakset;

/**
 * Edustaa pelaajaa Kivi-Paperi-Sakset -pelissä.
 */
public class Pelaaja {
    private int voitot = 0; // Voittojen lukumäärä

    /**
     * Valitsee satunnaisesti kiven, paperin tai sakset.
     * @return Merkkijono, joka edustaa pelaajan valintaa.
     */
    public String pelaajanValinta() {
        int choice = (int) (Math.random() * 3);
        switch (choice) {
            case 0:
                return "kivi";
            case 1:
                return "paperi";
            case 2:
                return "sakset";
            default:
                return ""; // Tätä tapausta ei pitäisi esiintyä
        }
    }

    /**
     * Kasvattaa pelaajan voittojen määrää.
     */
    public void incrementVoitot() {
        voitot++;
    }

    /**
     * Palauttaa pelaajan tämänhetkisen voittojen määrän.
     * @return Voittojen määrä.
     */
    public int getVoitot() {
        return voitot;
    }
}
