public class NemSzeretiException extends Exception {

    private final Jatek melyikJatekot;
    public NemSzeretiException(Jatek melyiket) {
        super("A jatekos nem szereti a " + melyiket.getNev() + " jatekot.");
        this.melyikJatekot = melyiket;
    }

    public Jatek getMelyikJatekot() {
        return melyikJatekot;
    }

}
