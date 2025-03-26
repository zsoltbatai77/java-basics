import java.sql.Array;
import java.util.*;

public class Bolt {
    private boolean nagyker;
    private Map<String, Integer> termekArak = new HashMap<>();
    private Map<String, Integer> termekMennyisegek = new HashMap<>();

    public Bolt(boolean nagyker) {
        this.nagyker = nagyker;
    }

    public Integer[] termekAdat(String termekNeve){
        if(termekMennyisegek.containsKey(termekNeve)){
            return new Integer[]{termekArak.get(termekNeve),termekMennyisegek.get(termekNeve)};
        }
        return new Integer[]{null, null};
    }

    public void ujAru(String termekNeve, int mennyiseg){
        if(!termekMennyisegek.containsKey(termekNeve)){
            termekArak.put(termekNeve, 1000);
            termekMennyisegek.put(termekNeve, mennyiseg);
        } else {
            int ertek = termekMennyisegek.get(termekNeve);
            termekMennyisegek.put(termekNeve, mennyiseg + ertek);
        }
    }

    public String[] rendez(boolean arAlapjan){
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(termekArak.entrySet());
        if (arAlapjan){
            lista.sort(Map.Entry.comparingByValue());
        } else {
            lista.sort(Map.Entry.comparingByKey());
        }
        String[] rendezettNevek = new String[lista.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : lista){
            rendezettNevek[i++] = (entry.getKey());
        }
        return rendezettNevek;
    }

    public void arValtozas(String termekNeve, int minimumAr, int ajanlottAr){
        if (termekMennyisegek.containsKey(termekNeve)){
            if (this.nagyker){
                termekArak.put(termekNeve, minimumAr);
            } else {
                termekArak.put(termekNeve, ajanlottAr);
            }
        }
    }

    public boolean megTudtaVenni(Vasarlo vasarlo, Map<String, Integer> bevasarlolista){
        int szuksegesPenz = 0;
        boolean mindentMegvett = true;
        Map<String, Integer> vasaroltTermekMennyisegek = new HashMap<>();
        for(Map.Entry<String, Integer> entry : bevasarlolista.entrySet()){
            if(termekMennyisegek.containsKey(entry.getKey())){
                if(termekMennyisegek.get(entry.getKey()) < entry.getValue()) mindentMegvett = false;
                int vasaroltMennyiseg = Math.min(termekMennyisegek.get(entry.getKey()), entry.getValue());
                vasaroltTermekMennyisegek.put(entry.getKey(), vasaroltMennyiseg);
                szuksegesPenz += vasaroltMennyiseg * termekArak.get(entry.getKey());
            }
        }
        if(szuksegesPenz > vasarlo.getPenz()){
            return false;
        } else if (!mindentMegvett) {
            for(Map.Entry<String, Integer> entry : vasaroltTermekMennyisegek.entrySet()){
                termekMennyisegek.put(entry.getKey(), termekMennyisegek.get(entry.getKey()) - entry.getValue());
            }
            vasarlo.penztKolt(szuksegesPenz);
            return false;
        } else {
            for(Map.Entry<String, Integer> entry : vasaroltTermekMennyisegek.entrySet()){
                termekMennyisegek.put(entry.getKey(), termekMennyisegek.get(entry.getKey()) - entry.getValue());
            }
            vasarlo.penztKolt(szuksegesPenz);
            return true;
        }
    }
}
