import java.util.Objects;

public class AutosFutar extends EtelFutar{
    private final String napszak;

    public AutosFutar(int ertek, String napszak) {
        super(60, ertek);
        this.napszak = napszak;
    }

    @Override
    public boolean idobenErkezik(int tavolsag, int ennyiIdejeVan) {
        if (Objects.equals(this.napszak, "delben") || Objects.equals(this.napszak, "este")){
            this.setSebesseg(this.getSebesseg()/3);
        }
        double ido = (tavolsag/getSebesseg() * 60.0);
        return ennyiIdejeVan >= ido;
    }
}
