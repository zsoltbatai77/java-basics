public class SovenyvagoOllo {

    private double elesseg;

    public SovenyvagoOllo() {
        this.elesseg = 100;
    }

    public double getElesseg() {
        return elesseg;
    }

    public void elez() {
        if (elesseg <= 85) {
            elesseg += 15;
        }
    }

    public boolean vag(double suruseg) {
        if (elesseg >= suruseg) {
            elesseg -= suruseg;
            return true;
        }
        return false;
    }
}


