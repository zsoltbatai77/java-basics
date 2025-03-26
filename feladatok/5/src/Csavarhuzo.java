public class Csavarhuzo {

    private int meret;

    protected Csavarfej csavarfej;

    public Csavarhuzo(int meret, Csavarfej fej){
        this.meret = meret;
        this.csavarfej = fej;


    }

    public int getMeret() {
        return meret;
    }


    public Csavarfej getCsavarfej() {
        return csavarfej;
    }

    public void setMeret(int meret) {
        this.meret = meret;
    }


    @Override
    public String toString() {
        if(this.csavarfej == Csavarfej.EGYHORNYU){
            return "hagyomanyos feju csavarhuzo";
        }

        else if (this.csavarfej == Csavarfej.PHILLIPS) {
            return "csillagfeju csavarhuzo";

        }

        return "imbuszfeju csavarhuzo";
    }


}
