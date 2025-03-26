
public abstract class EtelFutar {
    private double sebesseg;
    private final int ertek;

    public EtelFutar(double sebesseg, int ertek) {
        this.sebesseg = sebesseg;
        this.ertek = ertek;
    }

    public double getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(double sebesseg) { this.sebesseg = Math.max(sebesseg, 5); }

    public int getErtek() {
        return ertek;
    }


    public abstract boolean idobenErkezik(int tavolsag, int ennyiIdejeVan);
}
