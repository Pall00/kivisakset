package kivipaperisakset;
/**
 * Peli-luokka hallinnoi Kivi-Paperi-Sakset -pelin toimintalogiikkaa.
 */
public class Peli {
    Pelaaja p1 = new Pelaaja();
    Pelaaja p2 = new Pelaaja();
    int pelatutPelit = 0; // Pelattujen pelien lukumäärä
    int tasapelit = 0;    // Tasapelien lukumäärä

    /**
     * Pelin päämetodi. Käynnistää ja hallinnoi pelin kulkua.
     * 
     * @param args Komentoriviparametrit (ei käytössä).
     */
    public static void main(String args[]) {
        Peli peli = new Peli();
        peli.pelaaPeli();
    }

     /**
     * Suorittaa pelin, kunnes toinen pelaajista saavuttaa kolme voittoa.
     * Hallinnoi pelin kierrokset ja tarkistaa pelin lopputilanteen.
     */
    public void pelaaPeli() {
        boolean peliLoppui = false;

        while (!peliLoppui) {
            pelaaKierros();
            if (p1.getVoitot() >= 3 || p2.getVoitot() >= 3) {
                peliLoppui = true;
            }
        }

        // Tulosta pelin lopputulos
        System.out.println("Peli päättyi. Voittaja: " + (p1.getVoitot() > p2.getVoitot() ? "Pelaaja 1" : "Pelaaja 2"));
    }

    /**
     * Pelaa yhden kierroksen Kivi-Paperi-Sakset -peliä.
     * Päivittää pelattujen pelien, tasapelien ja voittojen tilastot.
     */
    public void pelaaKierros() {
        String p1Valinta = p1.pelaajanValinta();
        String p2Valinta = p2.pelaajanValinta();
        System.out.println("Erä: " + pelatutPelit + " =====================\n");
        System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
        System.out.println("Pelaaja 1 valitsi: " + p1Valinta);
        System.out.println("Pelaaja 2 valitsi: " + p2Valinta);

        String tulos = tarkistaVoittaja(p1Valinta, p2Valinta);
        if (tulos.equals("tasapeli")) {
            tasapelit++;
            System.out.println("Tasapeli!");
        } else if (tulos.equals("p1")) {
            p1.incrementVoitot();
            System.out.println("Pelaaja 1 voittaa kierroksen!");
        } else {
            p2.incrementVoitot();
            System.out.println("Pelaaja 2 voittaa kierroksen!");
        }
        pelatutPelit++;
    }

    /**
     * Tarkistaa kierroksen voittajan annettujen valintojen perusteella.
     * 
     * @param p1Valinta Pelaaja 1:n valinta.
     * @param p2Valinta Pelaaja 2:n valinta.
     * @return Palauttaa "p1" jos pelaaja 1 voittaa, "p2" jos pelaaja 2 voittaa, tai "tasapeli".
     */
    public String tarkistaVoittaja(String p1Valinta, String p2Valinta) {
        if (p1Valinta.equals(p2Valinta)) {
            return "tasapeli";
        } else if ((p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) ||
                   (p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) ||
                   (p1Valinta.equals("paperi") && p2Valinta.equals("kivi"))) {
            return "p1";
        } else {
            return "p2";
        }
    }
}
