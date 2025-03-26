import java.util.HashMap;
import java.util.Map;

public class Jatekos {

    private String nev;
    private Jatek kedvenc;
    private Map<Jatek, Integer> eddigJatszott;

    public Jatekos(String nev) {
        this.nev = nev;
        this.kedvenc = null;
        this.eddigJatszott = new HashMap<>();
    }

    public void jatszik(Jatek mit, int mennyit) throws NemSzeretiException {

    }


    public String getNev() {
        return nev;
    }

    public Jatek getKedvenc() {
        return kedvenc;
    }

}
