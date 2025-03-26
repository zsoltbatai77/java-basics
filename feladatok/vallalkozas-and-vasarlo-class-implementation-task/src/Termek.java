public class Termek implements Comparable<Termek>{
    private final String nev;
    private int ar;
    private int mennyiseg;

    public Termek(String nev, int mennyiseg) {
        this.nev = nev;
        this.mennyiseg = mennyiseg;
        this.ar = 1000;
    }



    @Override
    public int compareTo(Termek o) {
        return 0;
    }
}
