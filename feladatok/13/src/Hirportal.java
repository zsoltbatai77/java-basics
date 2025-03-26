import com.sun.source.tree.BreakTree;

import java.io.*;
import java.util.*;
public class Hirportal {
    private boolean reklamos;
    private Map<String, Integer> latogatoCikkszam = new HashMap<>();
    private Map<String, Integer> latogatoErdeklodes = new HashMap<>();
    private Map<String, Integer> latogatoEv = new HashMap<>();

    public Hirportal(boolean reklamos) {
        this.reklamos = reklamos;
    }

    public Integer[] lekerdez(String nev){
        if (!latogatoCikkszam.containsKey(nev)){
            return new Integer[]{null, null, null};
        } else {
            return new Integer[]{latogatoCikkszam.get(nev), latogatoErdeklodes.get(nev), latogatoEv.get(nev)};
        }
    }

    public void ujLatogato(String nev, int db, int ev){
        if (!latogatoCikkszam.containsKey(nev)){
            latogatoCikkszam.put(nev, db);
            latogatoErdeklodes.put(nev, 100);
        } else {
            latogatoCikkszam.put(nev, latogatoCikkszam.get(nev) + db);
        }
        latogatoEv.put(nev, ev);
    }

    public void csokkenoErdeklodes(String nev, String mennyire){
        int szorzo = 1;
        if (reklamos) szorzo = 3;
        if (Objects.equals(mennyire, "nagyonnem")){
            latogatoErdeklodes.put(nev, latogatoErdeklodes.get(nev) - (10*szorzo));
        } else {
            latogatoErdeklodes.put(nev, latogatoErdeklodes.get(nev) - (2*szorzo));
        }
    }

    public String[] rendez(boolean abcSzerint){
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(latogatoErdeklodes.entrySet());
        if (abcSzerint){
            lista.sort(Map.Entry.comparingByKey());
        } else {
            lista.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        }
        String[] rendezettNevek = new String[lista.size()];

        int i = 0;
        for (Map.Entry<String, Integer> entry : lista){
            rendezettNevek[i++] = entry.getKey();
        }
        return rendezettNevek;
    }

    public Map<Integer, Integer> jovedelemMeghatarozas(List<Szoveg> cikkek, List<Integer> evszamok){
        //évszám, jövedelem
        Map<Integer, Integer> valami = new TreeMap<>();
        int kezdetiHozam = 0;
        for (Integer ev : evszamok){
            for (Szoveg cikk : cikkek){
                cikk.hozamKiszamit(ev);
                kezdetiHozam += cikk.getHozam();
            }
            int osszesLatogatas = 0;
            for (Map.Entry<String, Integer> entry : latogatoEv.entrySet()){
                if (entry.getValue() == ev){
                    osszesLatogatas++;
                }
            }
            if (osszesLatogatas > 10){
                kezdetiHozam += osszesLatogatas/ cikkek.size();
            }
            valami.put(ev, kezdetiHozam);
        }
        return valami;
    }
}
