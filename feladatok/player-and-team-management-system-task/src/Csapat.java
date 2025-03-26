import java.util.ArrayList;
import java.util.List;

public class Csapat {

    private final Jatek celJatek;
    private final int maxLetszam;
    private List<Jatekos> jatekosok;

    public Csapat(Jatek celJatek, int maxLetszam) {
        this.celJatek = celJatek;
        this.maxLetszam = maxLetszam;
        this.jatekosok = new ArrayList<>();
    }
    public void jatekostHozzaad(Jatekos jatekos) {
        if (!celJatek.equals(jatekos.getKedvenc())) {
            throw new IllegalArgumentException("Ezt a jatekost nem lehet a csapathoz adni!");
        }
        if (jatekosok.size() >= maxLetszam) {
            throw new IndexOutOfBoundsException("Ide mar nem fer jatekos!");
        }
        jatekosok.add(jatekos);
    }

    public Jatek getCelJatek() {
        return celJatek;
    }

    public int getMaxLetszam() {
        return maxLetszam;
    }

    public List<Jatekos> getJatekosok() {
        return jatekosok;
    }

}
