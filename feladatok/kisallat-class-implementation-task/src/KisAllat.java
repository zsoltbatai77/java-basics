
import java.util.HashMap;
import java.util.Map;

public class KisAllat implements Comparable<KisAllat>{
    private String nev;
    private String csipSzam;
    private int tulajokSzama;
    private Map<String, Integer> boldogNapok;

    public KisAllat(String nev, String csipSzam, int tulajokSzama, Map<String, Integer> boldogNapok) {
        this.nev = nev;
        this.csipSzam = csipSzam;
        this.tulajokSzama = tulajokSzama;
        this.boldogNapok = boldogNapok;
    }

    public void addBoldognap(){
        this.boldogNapok = new HashMap<>() {{
            put("Pentek", tulajokSzama*3);
        }};
    }

    public Map<String, Integer> getBoldogNapok() {
        return boldogNapok;
    }

    @Override
    public String toString() {
        return "KisAllat{" +
                "nev='" + nev + '\'' +
                ", csipSzam='" + csipSzam + '\'' +
                ", tulajokSzama='" + tulajokSzama + '\'' +
                ", boldogNapok=" + boldogNapok +
                '}';
    }

    public int legboldogabbNap(){
        int max = 0;
        for (Map.Entry<String, Integer> entry : this.getBoldogNapok().entrySet()){
            if (entry.getValue() > max) max = entry.getValue();
        }
        return max;
    }

    @Override
    public int compareTo(KisAllat kisAllat) {
        int eredmeny = Integer.compare(kisAllat.legboldogabbNap(), this.legboldogabbNap());
        if (eredmeny == 0){
            return this.csipSzam.compareTo(kisAllat.csipSzam);
        }
        return eredmeny;
    }
}
