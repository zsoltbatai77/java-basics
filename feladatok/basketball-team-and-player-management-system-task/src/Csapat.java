import java.io.*;
import java.util.*;

public class Csapat  implements Comparable<Csapat>{
    private final String neve;
    private Map<String, List<Jatekos>> jatekosok = new HashMap<>();
    private String poziciok;

    public Csapat(String neve) {
        this.neve = neve;
    }

    public String getNeve() {
        return neve;
    }

    public void setJatekosok(Map<String, List<Jatekos>> jatekosok) {
        this.jatekosok = jatekosok;
    }

    public Map<String, List<Jatekos>> getJatekosok() {
        return jatekosok;
    }

    public void beolvas(File fajlnev) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fajlnev));

            String sor = br.readLine();

            while(sor != null){
                String[] darabok = sor.split(";");
                String pozicio = darabok[1];
                Jatekos jatekos = new Jatekos(darabok[0], Integer.parseInt(darabok[2]), Integer.parseInt(darabok[3]), Integer.parseInt(darabok[4]));
                if (!jatekosok.containsKey(pozicio)) {
                    jatekosok.put(pozicio, new ArrayList<>());
                }

                jatekosok.get(pozicio).add(jatekos);

            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> hianyzoPoziciok(){
        List<String> poziciok = Arrays.asList("Starting Pitcher", "First Baseman", "Shortstop", "Third Baseman", "Designated Hitter", "Catcher", "Second Baseman", "Relief Pitcher", "Outfielder");
        List<String> hianyzoPoziciok = new ArrayList<>();

        for (String pozicio : poziciok){
            if (!jatekosok.containsKey(pozicio)) {
                hianyzoPoziciok.add(pozicio);
            }
        }

        return hianyzoPoziciok;
    }

    public float atlag(String melyikAtlag){
        float osszesen = 0;
        int db = 0;
        if (Objects.equals(melyikAtlag, "magassag")){
            for (Map.Entry<String, List<Jatekos>> entry : this.jatekosok.entrySet()){
                for (Jatekos jatekos : entry.getValue()) {
                    osszesen += jatekos.getMagassag();
                    db++;
                }
            }
        } else if (Objects.equals(melyikAtlag, "suly")) {
            for (Map.Entry<String, List<Jatekos>> entry : this.jatekosok.entrySet()){
                for (Jatekos jatekos : entry.getValue()) {
                    osszesen += jatekos.getSuly();
                    db++;
                }
            }
        }
        if (db > 0){
            return osszesen/db;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Csapat o) {
        int eredmeny = Integer.compare((int) this.atlag("magassag"), (int) o.atlag("magassag"));
        if (eredmeny == 0){
            eredmeny = Integer.compare((int) o.atlag("suly"), (int) this.atlag("suly"));
        }
        if (eredmeny == 0){
            return 1;
        }
        return eredmeny;
    }
}
