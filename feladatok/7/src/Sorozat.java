public class Sorozat extends TVMusor{

    private int korhatarBesorolas;
    public Sorozat(String nev, double hossz, int... reszekKorhatarBesorolasa) {
        super(nev, hossz);
        if (reszekKorhatarBesorolasa.length > 0) {
            korhatarBesorolas = reszekKorhatarBesorolasa[0];
        } else {
            korhatarBesorolas = 0;
        }
        for (int korhatar : reszekKorhatarBesorolasa){
            if (korhatar > korhatarBesorolas) korhatarBesorolas = korhatar;
        }
    }
    @Override
    public int getKorhatarBesorolas() {
        return korhatarBesorolas;
    }
}
