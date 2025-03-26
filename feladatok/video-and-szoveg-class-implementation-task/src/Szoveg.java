import java.io.*;
import java.util.*;

public class Szoveg implements interfaceeeee{
    private String cim;
    private final String tartalom;
    private int hozam;
    private String infoFile;

    public Szoveg(String cim, String tartalom, String infoFile) {
        this.cim = cim;
        this.tartalom = tartalom;
        this.infoFile = infoFile;
        this.hozam = 0;
    }

    public String getCim() {
        return cim;
    }

    public int getHozam() {
        return hozam;
    }

    public void valogat(int minHossz) {
        if (cim.contains("false")) {
            throw new hibaException("Ez a hir csak kitalacio!");
        } else {
            String[] szavak = cim.split(" ");
            cim = "";
            int i = 0;
            for (String szo : szavak){
                i++;
                if (szo.length() > minHossz){
                    if (szavak.length == i){
                        cim += szo;
                    } else {
                        cim += szo + " ";
                    }
                }
            }
        }
    }

    public void hozamKiszamit(int ev){
        int hozam = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.infoFile));
            String sor = br.readLine();
            while(sor != null){
                String[] adat = sor.split(";");
                if (Integer.parseInt(adat[0]) == ev){
                    hozam += Integer.parseInt(adat[2])-Integer.parseInt(adat[3]);
                }
                sor = br.readLine();
            }
            this.hozam = hozam;
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
