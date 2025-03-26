public class KerekparosFutar extends EtelFutar{

    private final int etelMennyiseg;
    private int energia;
    public KerekparosFutar(int ertek, int etelMennyiseg) {
        super(25, ertek);
        this.etelMennyiseg = etelMennyiseg;
        this.energia = 100;
        this.setSebesseg(25);
    }

    @Override
    public boolean idobenErkezik(int tavolsag, int ennyiIdejeVan) {
        this.setSebesseg(this.getSebesseg()*((double) getEnergia() /100));
        if (this.etelMennyiseg > 5){
            this.setSebesseg(this.getSebesseg()-((this.etelMennyiseg/5))*2);
        }
        this.setEnergia(this.getEnergia()-tavolsag);
        if (this.getEnergia() < 0){
            this.setEnergia(0);
        }
        double ido = (tavolsag/this.getSebesseg()) * 60.0;
        return ennyiIdejeVan > ido;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
}
