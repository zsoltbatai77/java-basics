public abstract class TVMusor implements BesorolassalRendelkezo {

    protected double hossz;
    protected final String nev;

    public TVMusor(String nev, double hossz) {
        if (hossz < 0) {
            this.hossz = 0;
        } else {
            this.hossz = hossz;
        }
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public double getHossz() {
        return hossz;
    }

    public void setHossz(double hossz) {
        if (hossz < 0) {
            this.hossz = 0;
        } else {
            this.hossz = hossz;
        }
    }
}
