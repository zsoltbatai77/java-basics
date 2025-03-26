import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.*;

public class Vasarlo implements EgyInterface{
    public final String nev;
    protected String igazolvanySzam;
    private int penz;

    public Vasarlo(String nev, String igazolvanySzam) {
        this.nev = nev;
        this.igazolvanySzam = igazolvanySzam;
        this.penz = 0;
    }

    public int getPenz() {
        return penz;
    }

    public void penztKolt(int mennyit){
        if (getPenz() < mennyit) {
            throw new NemJoException("Nincs eleg penz!");
        } else {
            this.penz -= mennyit;
        }
    }

    public void vagyontKiszamit(String filename){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String sor = br.readLine();

            while(sor != null){
                String[] darabok = sor.split(";");
                if (Objects.equals(darabok[1], "BEVETEL")){
                    this.penz += Integer.parseInt(darabok[2]);
                } else if (Objects.equals(darabok[1], "KIADAS")) {
                    this.penz -= Integer.parseInt(darabok[2]);
                }

                sor = br.readLine();

            }

            br.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
