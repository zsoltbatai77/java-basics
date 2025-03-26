import java.util.Objects;

public class Zeneszam implements BesorolassalRendelkezo{
    private String eloado;
    private String szamCim;
    private String szoveg;

    public Zeneszam(String eloado, String szamCim, String szoveg) {
        this.eloado = eloado;
        this.szamCim = szamCim;
        this.szoveg = szoveg;
    }

    public String getEloado() {
        return eloado;
    }

    public String getSzamCim() {
        return szamCim;
    }

    public String getSzoveg() {
        return szoveg;
    }

    public void setEloado(String eloado) {
        this.eloado = eloado;
    }

    public void setSzamCim(String szamCim) {
        this.szamCim = szamCim;
    }

    public void setSzoveg(String szoveg) {
        this.szoveg = szoveg;
    }

    @Override
    public int getKorhatarBesorolas() {
        int db = 0;
        String tragarSzo = "xeierirg kuoulzz pqtruei fktilop kxre eifei csozrox";
        String[] tragarSzavak = tragarSzo.split(" ");
        String[] szavak = szoveg.split(" ");
        for (String szo : szavak) {
            for (String szo2 : tragarSzavak) {
                if (Objects.equals(szo, szo2)) db += 1;
            }
        }
        return db;
    }
}
