
import java.util.*;

public class Zh47 {

    public static Collection<KisAllat> rendez(KisAllat[] kisAllatok) {
        if (kisAllatok == null || kisAllatok.length == 0){
            return new ArrayList<>(0);
        } else{
            List<KisAllat> lista = new ArrayList<>(Arrays.asList(kisAllatok));
            Collections.sort(lista);
            return lista;
        }
    }

    public static void teddBoldogga(List<KisAllat> kisAllatok) {
        List<KisAllat> ideiglenes = new ArrayList<>();
//        if(!(kisAllatok.removeIf(kisAllat -> !kisAllat.getBoldogNapok().isEmpty()))){
//            kisAllatok.addBol;
//        }

        for (KisAllat allat : kisAllatok){
            if (allat.getBoldogNapok().isEmpty()){
                allat.addBoldognap();
            } else {
                ideiglenes.add(allat);
            }
        }

        for (KisAllat allat : ideiglenes){
            kisAllatok.remove(allat);
        }
    }

    /**
     * A main metodusban kedved szerint kiprobalhatod a programod, tesztelheted, amihez felhasznalhatod
     * a mar adott kisallatokat, de ujakat is keszithetsz.
     * A main atirasa egyaltalan nem befolyasolja a kiertekeles menetet!
     *
     * @param args
     */
    public static void main(String[] args) {
        KisAllat kisAllat1 = new KisAllat("Buksi", "NGRSPJ", 3, new HashMap<>(){{put("Kedd",5); put("Szerda",4); put("Pentek",3);}});
        KisAllat kisAllat2 = new KisAllat("Dolli", "XGRSPJ", 4, new HashMap<>(){{put("Kedd",4); put("Csutortok",4); put("Vasarnap",4);}});
        KisAllat kisAllat3 = new KisAllat("Kocos", "JRRAGS", 1, new HashMap<>(){{put("Pentek",5); put("Vasarnap",4);}});

        KisAllat[] kisAllatok = new KisAllat[]{kisAllat1, kisAllat2, kisAllat3};
        List<KisAllat> rendezett = new ArrayList<>();
        rendezett.addAll(rendez(kisAllatok));
        for (KisAllat adottKisAllat : rendezett) {
            System.out.println(adottKisAllat); // Eredmenyek kiirasa
        }
    }

}