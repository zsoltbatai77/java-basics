public class Bokor {

    private String fajta;

    private int forma;

    private double suruseg;

    public Bokor(String fajta, double suruseg) {
        if(suruseg >= 0 || suruseg <= 100){
            this.suruseg = suruseg;
        }
        this.fajta = fajta;
    }

    public String forma() {
        if (this.forma == 0) {
            return "cserje";
        } else if (this.forma == 1) {
            return "bokor";

        } else if (this.forma == 2) {
            return "formara nyirt";

        } else if (this.forma == 3) {
            return "kisse elburjanzott";

        }

        return "teljesen elburjanzott";
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }

    public void setForma(int forma) {
        if (forma <= 4 && forma >= 0) {
            this.forma = forma;
        }

    }

    public void setSuruseg(double suruseg) {
        if (suruseg >= 100) {
            this.suruseg = 100;
        } else if (suruseg <= 0) {

            this.suruseg = 0;
        }

    }

    public double getSuruseg() {
        return suruseg;
    }

    public String getFajta() {
        return fajta;
    }

    public void nyiras(SovenyvagoOllo ollo) {
        if (ollo.vag(this.suruseg)) {
            setForma(2);
        }
    }

    public void novekedes() {

    }
}
